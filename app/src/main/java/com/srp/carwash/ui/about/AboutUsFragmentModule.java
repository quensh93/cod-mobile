package com.srp.carwash.ui.about;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class AboutUsFragmentModule {

    @Provides
    AboutUsFragmentViewModel provideAboutUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new AboutUsFragmentViewModel(dataManager, schedulerProvider);
    }
}
