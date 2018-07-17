package com.epuzzle.epuzzlemvvm.di;

import com.epuzzle.epuzzlemvvm.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuildersModule.class})

public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App app);
        AppComponent build();
    }

    void inject(App application);
}
