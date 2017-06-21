package com.docon.assignment.assignmentdocon.model.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

/**
 * Created by rahul on 21/6/17.
 */
@Generated("org.jsonschema2pojo")
public class UsersResponse {

    @SerializedName("data")
    @Expose
    private List<UsersData> userDataList;

    @SerializedName("page")
    @Expose
    private int page;

    @SerializedName("per_page")
    @Expose
    private int perPage;

    @SerializedName("total")
    @Expose
    private int totalUsers;

    @SerializedName("total_pages")
    @Expose
    private int totalPages;

    public List<UsersData> getUserDataList() {
        return userDataList;
    }

    public void setUserDataList(List<UsersData> userDataList) {
        this.userDataList = userDataList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
