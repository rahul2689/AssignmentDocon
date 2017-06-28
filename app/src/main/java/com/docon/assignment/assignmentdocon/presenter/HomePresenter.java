package com.docon.assignment.assignmentdocon.presenter;

import com.docon.assignment.assignmentdocon.model.UsersResponse;
import com.docon.assignment.assignmentdocon.network_connection.CommonErrors;
import com.docon.assignment.assignmentdocon.network_connection.NetworkService;
import com.docon.assignment.assignmentdocon.view.IHomeView;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by rahul on 20/6/17.
 */

public class HomePresenter {
    private final NetworkService service;
    private final IHomeView view;
    private CompositeSubscription subscriptions;

    public HomePresenter(NetworkService service, IHomeView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getUserDataList(int page) {
        view.showProgressBar();

        Subscription subscription = service.getUsersDataList(new NetworkService.GetUserDataListCallback() {
            @Override
            public void onSuccess(UsersResponse usersResponse) {
                view.removeProgressBar();
                view.getUserDataList(usersResponse);
            }

            @Override
            public void onError(CommonErrors networkError) {
                view.removeProgressBar();
                view.onFailure(networkError.getAppErrorMessage());
            }

        }, page);

        subscriptions.add(subscription);
    }
    public void onStop() {
        subscriptions.unsubscribe();
    }
}
