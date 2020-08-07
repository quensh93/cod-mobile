package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionModel {

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("versionName")
    private String versionName;

    @Expose
    @SerializedName("versionCode")
    private int versionCode;

    @Expose
    @SerializedName("downloadLink")
    private String downloadLink;

    @Expose
    @SerializedName("description")
    private String description;

    @Expose
    @SerializedName("shopUrl")
    private String shopUrl;

    @Expose
    @SerializedName("createdAt")
    private String createdAt;

    public int getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public String getVersionName() {
        return versionName;
    }
}
