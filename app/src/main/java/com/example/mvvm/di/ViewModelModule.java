package com.example.mvvm.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.mvvm.ui.main.MainActivityViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    ViewModel bindMainActivityViewModel(MainActivityViewModel mainActivityViewModel);

    @Binds
    ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory appViewModelFactory);
}
