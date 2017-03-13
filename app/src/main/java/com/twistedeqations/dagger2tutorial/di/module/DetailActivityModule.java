package com.twistedeqations.dagger2tutorial.di.module;

import com.twistedeqations.dagger2tutorial.di.scope.DetailActivityScope;
import com.twistedeqations.dagger2tutorial.screens.DetailActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cafer on 13.3.2017.
 */

@Module
public class DetailActivityModule {

    private final DetailActivity detailActivity;

    public DetailActivityModule(DetailActivity detailActivity) {
        this.detailActivity = detailActivity;
    }

    @Provides
    @DetailActivityScope
    public DetailActivity providesDetailActivity(){
        return detailActivity;
    }
}
