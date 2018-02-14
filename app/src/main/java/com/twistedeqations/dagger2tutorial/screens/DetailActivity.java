package com.twistedeqations.dagger2tutorial.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.twistedeqations.dagger2tutorial.GithubApplication;
import com.twistedeqations.dagger2tutorial.R;
import com.twistedeqations.dagger2tutorial.di.component.ActivityComponent;
import com.twistedeqations.dagger2tutorial.di.component.DaggerActivityComponent;
import com.twistedeqations.dagger2tutorial.di.module.ActivityModule;
import com.twistedeqations.dagger2tutorial.models.GithubRepo;
import com.twistedeqations.dagger2tutorial.models.GithubRepoOwner;
import com.twistedeqations.dagger2tutorial.network.GithubService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cafer on 13.3.2017.
 */

public class DetailActivity extends BaseActivity {

    Call<List<GithubRepo>> userRepositories;

    @Inject
    GithubService githubService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        activityComponent.inject(this);

        GithubRepoOwner githubRepoOwner = getIntent().getParcelableExtra("owner");

        if (githubRepoOwner != null)
            userRepositories = githubService.getReposForUser(githubRepoOwner.login);

        userRepositories.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                Toast.makeText(DetailActivity.this, response.body().get(0).fullName, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {

            }
        });
    }
}
