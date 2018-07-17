package com.example.mvvm.ui.main;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    FragmentActivity provideActivity(MainActivity activity) {
        return activity;
    }

    @Provides
    FragmentManager provideFragmentManager(MainActivity activity) {
        return activity.getSupportFragmentManager();
    }
}
