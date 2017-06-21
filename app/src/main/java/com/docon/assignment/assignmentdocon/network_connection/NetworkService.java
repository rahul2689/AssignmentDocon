package com.docon.assignment.assignmentdocon.network_connection;

import com.docon.assignment.assignmentdocon.model.home.UsersResponse;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by root on 20/6/17.
 */

public class NetworkService {

    private final INetworkService networkService;

    public NetworkService(INetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getUsersDataList(final GetUserDataListCallback callback, int page) {

        return networkService.getUserDataList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends UsersResponse>>() {
                    @Override
                    public Observable<? extends UsersResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<UsersResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new CommonErrors(e));

                    }

                    @Override
                    public void onNext(UsersResponse userDataResponse) {
                        callback.onSuccess(userDataResponse);

                    }
                });
    }

    public interface GetUserDataListCallback {
        void onSuccess(UsersResponse userDataResponse);

        void onError(CommonErrors errors);
    }
}
