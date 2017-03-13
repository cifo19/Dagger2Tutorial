package com.twistedeqations.dagger2tutorial.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.twistedeqations.dagger2tutorial.GithubApplication;
import com.twistedeqations.dagger2tutorial.R;
import com.twistedeqations.dagger2tutorial.di.component.DaggerDetailActivityComponent;
import com.twistedeqations.dagger2tutorial.di.component.DetailActivityComponent;
import com.twistedeqations.dagger2tutorial.di.module.DetailActivityModule;
import com.twistedeqations.dagger2tutorial.network.GithubService;

import javax.inject.Inject;

/**
 * Created by cafer on 13.3.2017.
 */

public class DetailActivity extends AppCompatActivity {

    DetailActivityComponent detailActivityComponent;

    @Inject
    GithubService githubService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        detailActivityComponent = DaggerDetailActivityComponent.builder()
                .detailActivityModule(new DetailActivityModule(this))
                .githubApplicationComponent(GithubApplication.get(this).githubApplicationComponent())
                .build();

        detailActivityComponent.inject(this);
    }
}
