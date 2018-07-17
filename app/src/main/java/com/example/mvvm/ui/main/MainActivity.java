package com.example.mvvm.ui.main;

import android.os.Bundle;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.ui.base.BaseActivity;
import com.example.mvvm.utils.Navigator;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> implements MainFragment.MainFragmentInteractor {

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBindView(this, R.layout.activity_main);
        navigator.openFragment(R.id.container, MainFragment.newInstance().setInteractor(this), null);
    }

    @Override
    public void openNextFragment() {}
}
