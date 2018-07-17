package com.epuzzle.epuzzlemvvm.di;

import com.epuzzle.epuzzlemvvm.ui.main.MainActivity;
import com.epuzzle.epuzzlemvvm.ui.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, FragmentBuildersModule.class})
    MainActivity contributeMainActivity();
}
