package com.twistedeqations.dagger2tutorial.di.component;

import com.twistedeqations.dagger2tutorial.di.module.ActivityModule;
import com.twistedeqations.dagger2tutorial.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by cafer on 14.2.2018.
 */

@Component(dependencies = GithubApplicationComponent.class, modules = ActivityModule.class)
@ActivityScope
public interface ActivityComponent extends ActivityInjector {
}
