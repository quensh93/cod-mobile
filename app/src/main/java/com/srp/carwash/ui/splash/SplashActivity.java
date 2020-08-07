package com.srp.carwash.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.srp.carwash.BR;
import com.srp.carwash.R;
import com.srp.carwash.databinding.ActivitySplashBinding;
import com.srp.carwash.ui.base.BaseActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    SplashViewModel mSplashViewModel;

    public static Intent newIntent(Context context) {
        return new Intent(context, SplashActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        return mSplashViewModel;
    }


    private void decideNext() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        try {
            mSplashViewModel.doCheckVersion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goNext() {

    }
}
