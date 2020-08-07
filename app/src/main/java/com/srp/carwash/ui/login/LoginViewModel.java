package com.srp.carwash.ui.login;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.google.gson.Gson;
import com.srp.carwash.R;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.LoginRequest;
import com.srp.carwash.data.model.api.LoginResponse;
import com.srp.carwash.data.model.api.RegisterRequest;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

import static com.srp.carwash.MvvmApp.token;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public ObservableField<String> userName = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();
    public ObservableField<String> fullName = new ObservableField<>();
    public ObservableField<String> email = new ObservableField<>();
    public ObservableField<String> mobile = new ObservableField<>();
    public ObservableField<String> repeatPassword = new ObservableField<>();
    public ObservableInt isError = new ObservableInt(0);

    // 0 -> login , 1 -> register, 2 -> forgetPass
    public ObservableInt state = new ObservableInt(0);
    public ObservableBoolean loadingStatus = new ObservableBoolean(false);

    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onClicked() {
        if (loadingStatus.get())
            return;

        if (state.get() == 0)
            if (userName.get() == null || userName.get().length() < 6)
                isError.set(1);
            else if (password.get() == null || password.get().length() < 6)
                isError.set(2);
            else
                getNavigator().onLogin();
        else if (state.get() == 1)
            if (fullName.get() == null || fullName.get().length() < 3)
                isError.set(3);
            else if (mobile.get() == null || mobile.get().length() != 11 || !mobile.get().startsWith("09"))
                isError.set(4);
            else if (email.get() == null || email.get().length() < 6 || !email.get().contains("@"))
                isError.set(5);
            else if (password.get() == null || password.get().length() < 6)
                isError.set(6);
            else if (repeatPassword.get() == null || repeatPassword.get().length() < 6)
                isError.set(7);
            else if (!password.get().equals(repeatPassword.get()))
                isError.set(8);
            else
                getNavigator().onRegister();
    }

    public void onChangeState(int s) {
        this.state.set(s);
    }

    public void setLoadingValue(boolean status) {
        loadingStatus.set(status);
    }

    public void doCallLogin() throws Exception {
        setLoadingValue(true);
        getCompositeDisposable().add(getDataManager()
                .doLogin(new LoginRequest(userName.get(), password.get()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            setLoadingValue(false);
                            LoginResponse verifyResponse = new Gson().fromJson(response, LoginResponse.class);
                            if (verifyResponse.isResult()) {
                                verifyResponse.getUser().save();
                                token = verifyResponse.getUser().getToken();
                                getNavigator().openMain();
                            } else
                                getNavigator().showMessage(R.string.error_login);
                        }
                        , throwable -> {
                            setLoadingValue(false);
                            getNavigator().showMessage(R.string.public_error);
                        }
                ));
    }

    public void doCallRegister() throws Exception {
        setLoadingValue(true);
        getCompositeDisposable().add(getDataManager()
                .doRegister(new RegisterRequest(fullName.get(), mobile.get(), email.get(), password.get()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            setLoadingValue(false);
                            if (response.equals("1")) {
                                password.set("");
                                state.set(0);
                            } else
                                getNavigator().showMessage(R.string.register_error);
                        }
                        , throwable -> {
                            setLoadingValue(false);
                            getNavigator().showMessage(R.string.public_error);
                        }
                ));
    }
}