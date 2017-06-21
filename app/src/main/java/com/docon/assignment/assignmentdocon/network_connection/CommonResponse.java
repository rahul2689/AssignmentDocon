package com.docon.assignment.assignmentdocon.network_connection;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 20/6/17.
 */

public class CommonResponse {

    @SerializedName("status")
    public String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @SuppressWarnings({"unused", "used by Retrofit"})
    public CommonResponse() {
    }

    public CommonResponse(String status) {
        this.status = status;
    }

}


