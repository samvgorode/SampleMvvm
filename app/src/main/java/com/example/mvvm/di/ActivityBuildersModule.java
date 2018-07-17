package com.example.mvvm.di;

import com.example.mvvm.ui.main.MainActivity;
import com.example.mvvm.ui.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, FragmentBuildersModule.class})
    MainActivity contributeMainActivity();
}
