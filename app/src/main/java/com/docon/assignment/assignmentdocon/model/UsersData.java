package com.docon.assignment.assignmentdocon.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

/**
 * Created by root on 21/6/17.
 */
@Generated("org.jsonschema2pojo")
public class UsersData implements Serializable {

    @SerializedName("id")
    @Expose
    private String userId;

    @SerializedName("first_name")
    @Expose
    private String userFirstName;

    @SerializedName("last_name")
    @Expose
    private String userLastName;

    @SerializedName("avatar")
    @Expose
    private String userImage;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserImageUrl() {
        return userImage;
    }

    public void setUserImageUrl(String userImage) {
        this.userImage = userImage;
    }

}
