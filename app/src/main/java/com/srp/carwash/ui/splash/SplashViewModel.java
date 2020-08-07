package com.srp.carwash.ui.splash;

import androidx.databinding.ObservableField;

import com.google.gson.Gson;
import com.srp.carwash.BuildConfig;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.VersionModel;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

import static com.srp.carwash.MvvmApp.shopUrl;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public ObservableField<VersionModel> versionModel = new ObservableField<>();

    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void doCheckVersion() throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doCheckVersion()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            VersionModel model = new Gson().fromJson(response, VersionModel.class);
                            shopUrl = model.getShopUrl();
                            versionModel.set(model);
                            if (BuildConfig.VERSION_CODE >= model.getVersionCode())
                                getNavigator().goNext();
                        }
                        , throwable -> {

                        }
                ));
    }

}
