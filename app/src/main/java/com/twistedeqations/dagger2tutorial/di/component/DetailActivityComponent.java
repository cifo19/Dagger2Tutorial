package com.twistedeqations.dagger2tutorial.di.component;

import com.twistedeqations.dagger2tutorial.di.module.DetailActivityModule;
import com.twistedeqations.dagger2tutorial.di.scope.DetailActivityScope;
import com.twistedeqations.dagger2tutorial.screens.DetailActivity;

import dagger.Component;

/**
 * Created by cafer on 13.3.2017.
 */

@Component(modules = {DetailActivityModule.class},dependencies = {GithubApplicationComponent.class})
@DetailActivityScope
public interface DetailActivityComponent {

    void inject(DetailActivity detailAcitivty);
}
