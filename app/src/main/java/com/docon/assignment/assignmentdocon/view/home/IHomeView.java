package com.docon.assignment.assignmentdocon.view.home;

import com.docon.assignment.assignmentdocon.model.home.UsersResponse;

/**
 * Created by root on 21/6/17.
 */

public interface IHomeView {
    void showProgressBar();

    void removeProgressBar();

    void onFailure(String appErrorMessage);

    void getUserDataList(UsersResponse usersResponse);
}
