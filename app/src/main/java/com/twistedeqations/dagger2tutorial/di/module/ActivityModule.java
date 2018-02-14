package com.twistedeqations.dagger2tutorial.di.module;

import android.support.v7.app.AppCompatActivity;

import com.twistedeqations.dagger2tutorial.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cafer on 14.2.2018.
 */

@Module
public class ActivityModule {
    private AppCompatActivity appCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    @ActivityScope
    public AppCompatActivity getActivity() {
        return appCompatActivity;
    }
}
