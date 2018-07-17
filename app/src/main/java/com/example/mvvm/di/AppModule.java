package com.example.mvvm.di;

import com.example.mvvm.App;
import com.example.mvvm.ui.main.MainActivityViewModel;
import com.example.mvvm.utils.ApplicationsDataManager;
import com.example.mvvm.utils.PermissionsUtil;
import com.example.mvvm.utils.ScreenUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    PermissionsUtil providePermissionsUtil() { return new PermissionsUtil(); }

    @Provides
    @Singleton
    ScreenUtils provideScreenUtils() { return new ScreenUtils(); }

    @Provides
    @Singleton
    ApplicationsDataManager provideApplicationsDataManager(App app) { return new ApplicationsDataManager(app); }

    @Provides
    Class<MainActivityViewModel> provideMainActivityViewModel() {
        return MainActivityViewModel.class;
    }
}
