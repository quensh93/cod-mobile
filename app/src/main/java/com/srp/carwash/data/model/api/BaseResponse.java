package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @Expose
    @SerializedName("result")
    private boolean result;

    public BaseResponse() {

    }

    public boolean isResult() {
        return result;
    }
}
