package com.epuzzle.epuzzlemvvm.di;

import com.epuzzle.epuzzlemvvm.ui.main.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface FragmentBuildersModule {

    @ContributesAndroidInjector
    MainFragment contributeMainFragment();
}
