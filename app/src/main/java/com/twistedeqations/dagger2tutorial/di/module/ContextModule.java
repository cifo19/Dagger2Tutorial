package com.twistedeqations.dagger2tutorial.di.module;

import android.content.Context;

import com.twistedeqations.dagger2tutorial.di.qualifier.ApplicationContext;
import com.twistedeqations.dagger2tutorial.di.scope.GithubApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lenovo on 30.11.2016.
 */

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context){
        this.context = context.getApplicationContext();
    }

    @Provides
    @GithubApplicationScope
    @ApplicationContext
    public Context context(){
        return context;
    }
}
