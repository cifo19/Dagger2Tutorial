package com.twistedeqations.dagger2tutorial.di.module;

import android.content.Context;

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
    public Context context(){
        return context;
    }
}
