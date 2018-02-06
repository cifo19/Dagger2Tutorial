package com.twistedeqations.dagger2tutorial.di.component;

import com.twistedeqations.dagger2tutorial.di.module.HomeActivityModule;
import com.twistedeqations.dagger2tutorial.di.scope.HomeActivityScope;
import com.twistedeqations.dagger2tutorial.screens.HomeActivity;

import dagger.Component;

/**
 * Created by Lenovo on 1.12.2016.
 */

@Component(modules = {HomeActivityModule.class}, dependencies = {GithubApplicationComponent.class})
@HomeActivityScope
public interface
HomeActivityComponent {
    void injectHomeActivity(HomeActivity homeActivity);
}
