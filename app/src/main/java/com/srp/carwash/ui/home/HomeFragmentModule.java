package com.srp.carwash.ui.home;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeFragmentModule {

    @Provides
    HomeFragmentViewModel provideRateUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new HomeFragmentViewModel(dataManager, schedulerProvider);
    }
}
