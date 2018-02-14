package com.twistedeqations.dagger2tutorial.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.twistedeqations.dagger2tutorial.GithubApplication;
import com.twistedeqations.dagger2tutorial.di.component.ActivityComponent;
import com.twistedeqations.dagger2tutorial.di.component.DaggerActivityComponent;
import com.twistedeqations.dagger2tutorial.di.module.ActivityModule;

/**
 * Created by cafer on 14.2.2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .githubApplicationComponent(GithubApplication.get(this).githubApplicationComponent())
                .build();
    }
}
