package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse extends BaseResponse {

    @Expose
    @SerializedName("user")
    private User user;

    public LoginResponse() {

    }

    public User getUser() {
        return user;
    }

}
