package com.srp.carwash.ui.about;


import com.srp.carwash.data.DataManager;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class AboutUsFragmentViewModel extends BaseViewModel<AboutUsFragmentCallback> {

    public AboutUsFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onBackClicked() {
        getNavigator().onBack();
    }

}
