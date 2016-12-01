package com.twistedeqations.dagger2tutorial.di.module;

import android.content.Context;

import com.twistedeqations.dagger2tutorial.di.scope.GithubApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lenovo on 30.11.2016.
 */

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Provides
    @GithubApplicationScope
    public Context context(){
        return context;
    }
}
