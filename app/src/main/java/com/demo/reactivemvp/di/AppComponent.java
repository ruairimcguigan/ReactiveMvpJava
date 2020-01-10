package com.demo.reactivemvp.di;

import android.app.Application;
import com.demo.reactivemvp.App;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

import javax.inject.Singleton;

/*
 * We mark this interface with the @Component annotation.
 * And we define all the modules that can be injected.
 * Note that we provide AndroidSupportInjectionModule.class
 * here. This class was not created by us.
 * It is an internal class in Dagger 2.10.
 * It provides our activities and fragments with given module.
 * */

@Component(modules = {
        AndroidInjectionModule.class,
        ActivityModule.class,
        FragmentModule.class
})
@Singleton
public interface AppComponent {

    /* We will call this builder interface from our custom Application class.
     * This will set our application object to the AppComponent.
     * So inside the AppComponent the application instance is available.
     * So this application instance can be accessed by our modules as needed
     */
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(App application);

        AppComponent build();
    }

    /*
      Root of app injection site - our custom App instance
    */
    void inject(App app);
}