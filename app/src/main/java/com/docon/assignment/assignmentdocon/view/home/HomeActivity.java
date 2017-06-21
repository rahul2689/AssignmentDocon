package com.docon.assignment.assignmentdocon.view.home;

/**
 * Created by root on 21/6/17.
 */

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.docon.assignment.assignmentdocon.BaseActivity;
import com.docon.assignment.assignmentdocon.R;
import com.docon.assignment.assignmentdocon.model.home.UsersData;
import com.docon.assignment.assignmentdocon.model.home.UsersResponse;
import com.docon.assignment.assignmentdocon.network_connection.NetworkService;
import com.docon.assignment.assignmentdocon.presenter.home.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity implements IHomeView {

    private RecyclerView mListRv;
    @Inject
    public NetworkService mNetworkService;
    private ProgressBar mProgressBar;
    private boolean mIsDataDownloading = false;
    private HomeAdapter mAdapter;
    private int mTotalUsers;
    private int mTotalPages;
    private List<UsersData> mUserDataList = new ArrayList<>();
    private int mPage = 1 ;
    private HomePresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDaggerInjector().inject(this);
        renderView();
        init();
        setScrollListernerOnRv();
        mPresenter = new HomePresenter(mNetworkService, this);
        mPresenter.getUserDataList(mPage);
    }

    private void setScrollListernerOnRv() {
        mListRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    /*int firstVisiblePosition = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
                    if (firstVisiblePosition == 0) {
                        mAppBarLayout.setExpanded(true, true);
                    }*/
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) //check for scroll down
                {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mListRv.getLayoutManager();
                    int visibleItemCount = linearLayoutManager.getChildCount();
                    int totalItemCount = linearLayoutManager.getItemCount();
                    int pastVisibleItems = linearLayoutManager.findFirstVisibleItemPosition();
                    int lastItem = visibleItemCount + pastVisibleItems;
                    if (isDataDownloadReq(lastItem, totalItemCount)) {
                        mIsDataDownloading = true;
                        mPresenter.getUserDataList(mPage);
                    }
                }
            }
        });
    }

    private boolean isDataDownloadReq(int lastItem, int totalItemCount) {
        if(lastItem == totalItemCount && !mIsDataDownloading && totalItemCount< mTotalUsers){
            return true;
        }
        return false;
    }

    public void renderView() {
        setContentView(R.layout.activity_home);
        mListRv = (RecyclerView) findViewById(R.id.listRv);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    public void init() {
        mListRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new HomeAdapter(this, new ArrayList<UsersData>(),
                new HomeAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(UsersData userData) {
                        Toast.makeText(getApplicationContext(), userData.getUserFirstName(),
                                Toast.LENGTH_LONG).show();
                    }
                });

        mListRv.setAdapter(mAdapter);
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {
        Toast.makeText(getApplicationContext(), appErrorMessage,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void getUserDataList(UsersResponse userResponse) {
        mIsDataDownloading = false;
         if(userResponse.getPage() == 1){
             mTotalUsers = userResponse.getTotalUsers();
             mTotalPages = userResponse.getTotalPages();
         }
         if(mAdapter != null){
             if(mPage <= mTotalPages){
                 mPage++;
             }
             mUserDataList.addAll(userResponse.getUserDataList());
             mAdapter.updateUserDataList(mUserDataList);
         }
    }
}