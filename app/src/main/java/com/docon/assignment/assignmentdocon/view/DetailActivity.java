package com.docon.assignment.assignmentdocon.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.docon.assignment.assignmentdocon.BaseActivity;
import com.docon.assignment.assignmentdocon.R;
import com.docon.assignment.assignmentdocon.model.UsersData;

/**
 * Created by root on 28/6/17.
 */

public class DetailActivity extends BaseActivity{



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getIntentData();
    }

    private void getIntentData() {
        Intent intent = getIntent();
        UsersData usersData = (UsersData) intent.getSerializableExtra("UserData");
        initView(usersData);
    }

    private void initView(UsersData usersData) {
        setContentView(R.layout.detail_view);
        TextView userIdTv = (TextView) findViewById(R.id.userId);
        TextView userFNameTv = (TextView) findViewById(R.id.userFirstName);
        TextView userLNameTv = (TextView) findViewById(R.id.userLastName);
        userIdTv.setText(usersData.getUserId());
        userFNameTv.setText(usersData.getUserFirstName());
        userLNameTv.setText(usersData.getUserLastName());
    }
}
