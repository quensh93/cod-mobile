package com.srp.carwash.ui.about;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AboutUsFragmentProvider {

    @ContributesAndroidInjector(modules = AboutUsFragmentModule.class)
    abstract AboutUsFragment provideAboutUsFragmentFactory();
}
