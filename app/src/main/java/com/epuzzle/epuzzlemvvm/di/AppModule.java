package com.epuzzle.epuzzlemvvm.di;

import com.epuzzle.epuzzlemvvm.App;
import com.epuzzle.epuzzlemvvm.ui.main.MainActivityViewModel;
import com.epuzzle.epuzzlemvvm.utils.ApplicationsDataManager;
import com.epuzzle.epuzzlemvvm.utils.PermissionsUtil;
import com.epuzzle.epuzzlemvvm.utils.ScreenUtils;

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
