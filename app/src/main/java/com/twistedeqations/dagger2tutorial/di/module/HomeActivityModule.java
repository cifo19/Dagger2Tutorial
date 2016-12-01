package com.twistedeqations.dagger2tutorial.di.module;

import com.squareup.picasso.Picasso;
import com.twistedeqations.dagger2tutorial.di.scope.HomeActivityScope;
import com.twistedeqations.dagger2tutorial.screens.HomeActivity;
import com.twistedeqations.dagger2tutorial.screens.home.AdapterRepos;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lenovo on 1.12.2016.
 */
@Module
public class HomeActivityModule {

    HomeActivity homeActivity;

    public HomeActivityModule(HomeActivity homeActivity){
        this.homeActivity = homeActivity;
    }

    @Provides
    @HomeActivityScope
    public AdapterRepos adapterRepos(Picasso picasso){
        return new AdapterRepos(homeActivity, picasso);
    }
}
