package com.twistedeqations.dagger2tutorial.di.module;

import android.app.Activity;
import android.content.Context;

import com.twistedeqations.dagger2tutorial.di.scope.GithubApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lenovo on 1.12.2016.
 */
@Module
public class ActivityModule {

    private Activity context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    @Provides
    @GithubApplicationScope
    @Named("activity_context")
    public Context context() {
        return context;
    }
}
