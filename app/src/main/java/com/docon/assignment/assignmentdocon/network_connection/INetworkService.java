package com.docon.assignment.assignmentdocon.network_connection;

import com.docon.assignment.assignmentdocon.model.home.UsersResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by root on 20/6/17.
 */

public interface INetworkService {

    @GET("api/users")
    Observable<UsersResponse> getUserDataList(@Query("page") int page);
}
