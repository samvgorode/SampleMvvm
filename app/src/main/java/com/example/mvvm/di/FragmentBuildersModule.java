package com.example.mvvm.di;

import com.example.mvvm.ui.main.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface FragmentBuildersModule {

    @ContributesAndroidInjector
    MainFragment contributeMainFragment();
}
