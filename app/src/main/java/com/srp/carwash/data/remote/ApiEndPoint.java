package com.srp.carwash.data.remote;

import com.srp.carwash.BuildConfig;

public final class ApiEndPoint {

    public static final String FORECASTS = BuildConfig.BASE_URL + "forecasts";
    public static final String CHECK_VERSION = BuildConfig.BASE_URL + "checkVersion";
    public static final String LOGIN = BuildConfig.BASE_URL + "login";
    public static final String REGISTER = BuildConfig.BASE_URL + "register";
    public static final String CONTACT_US = BuildConfig.BASE_URL + "contactUs";
    public static final String LOAD_AVATAR = BuildConfig.BASE_URL + "avatar";

    private ApiEndPoint() {

    }
}
