package com.docon.assignment.assignmentdocon.view;


import com.docon.assignment.assignmentdocon.model.UsersResponse;

/**
 * Created by root on 21/6/17.
 */

public interface IHomeView {
    void showProgressBar();

    void removeProgressBar();

    void onFailure(String appErrorMessage);

    void getUserDataList(UsersResponse usersResponse);
}
