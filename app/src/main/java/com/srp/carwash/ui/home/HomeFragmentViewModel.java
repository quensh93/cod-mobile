package com.srp.carwash.ui.home;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class HomeFragmentViewModel extends BaseViewModel<HomeFragmentCallback> {

    public HomeFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
