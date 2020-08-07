package com.srp.carwash.ui.about;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.srp.carwash.R;
import com.srp.carwash.databinding.FragmentAboutUsBinding;
import com.srp.carwash.ui.base.BaseFragment;

import javax.inject.Inject;

public class AboutUsFragment extends BaseFragment<FragmentAboutUsBinding, AboutUsFragmentViewModel> implements AboutUsFragmentCallback {

    public static final String TAG = AboutUsFragment.class.getSimpleName();

    @Inject
    AboutUsFragmentViewModel mViewModel;

    public static AboutUsFragment newInstance() {
        AboutUsFragment fragment = new AboutUsFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    @Override
    public int getBindingVariable() {
        return com.srp.carwash.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_about_us;
    }

    @Override
    public AboutUsFragmentViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onBack() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

}
