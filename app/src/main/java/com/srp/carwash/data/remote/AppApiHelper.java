package com.srp.carwash.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.srp.carwash.data.model.api.ContactUsRequest;
import com.srp.carwash.data.model.api.LoginRequest;
import com.srp.carwash.data.model.api.RegisterRequest;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

import static com.srp.carwash.MvvmApp.token;

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Single<String> doGetForecasts(String matchId) throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.FORECASTS + "/" + matchId)
                .addHeaders("Authorization", token)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doCheckVersion() throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.CHECK_VERSION)
                .addHeaders("Authorization", token)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doLogin(LoginRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.LOGIN)
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doRegister(RegisterRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.REGISTER)
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doContactUs(ContactUsRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.CONTACT_US)
                .addHeaders("Authorization", token)
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }
}
