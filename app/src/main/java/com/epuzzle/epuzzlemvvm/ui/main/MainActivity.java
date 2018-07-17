package com.epuzzle.epuzzlemvvm.ui.main;

import android.os.Bundle;

import com.epuzzle.epuzzlemvvm.R;
import com.epuzzle.epuzzlemvvm.databinding.ActivityMainBinding;
import com.epuzzle.epuzzlemvvm.ui.base.BaseActivity;
import com.epuzzle.epuzzlemvvm.utils.Navigator;

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
