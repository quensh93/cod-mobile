package com.srp.carwash.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.srp.carwash.BR;
import com.srp.carwash.R;
import com.srp.carwash.databinding.ActivityMainBinding;
import com.srp.carwash.ui.base.BaseActivity;
import com.srp.carwash.ui.home.HomeFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import kotlin.Unit;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator, HasSupportFragmentInjector {


    @Inject
    public MainViewModel mainViewModel;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    private boolean doubleBackToExitPressedOnce = false;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public MainViewModel getViewModel() {
        return mainViewModel;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel.setNavigator(this);

        setUpBottomNavigation();
        changeFragment(R.id.fl_main, HomeFragment.newInstance(), HomeFragment.TAG);

    }

    private void setUpBottomNavigation() {

        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_user));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_homee));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_user));
        bottomNavigation.show(2, true);

        bottomNavigation.setOnClickMenuListener(model -> {
            switch (model.getId()) {
                case 1:
                    //changeFragment(R.id.fl_main, ProfileFragment.newInstance(), ProfileFragment.TAG);
                    break;
                case 2:
                default:
                    changeFragment(R.id.fl_main, HomeFragment.newInstance(), HomeFragment.TAG);
                    break;
                case 3:
                    // changeFragment(R.id.fl_main, InvestmentFragment.newInstance(), InvestmentFragment.TAG);
                    break;
            }
            return Unit.INSTANCE;
        });
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
