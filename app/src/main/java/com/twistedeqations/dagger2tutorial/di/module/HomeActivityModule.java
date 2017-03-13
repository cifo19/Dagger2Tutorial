package com.twistedeqations.dagger2tutorial.di.module;

import com.twistedeqations.dagger2tutorial.di.scope.HomeActivityScope;
import com.twistedeqations.dagger2tutorial.screens.HomeActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lenovo on 1.12.2016.
 */
@Module
public class HomeActivityModule {

    private final HomeActivity homeActivity;

    public HomeActivityModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @Provides
    @HomeActivityScope
    public HomeActivity homeActivity() {
        return homeActivity;
    }
}
