package com.twistedeqations.dagger2tutorial.di.component;

import com.squareup.picasso.Picasso;
import com.twistedeqations.dagger2tutorial.di.module.GithubServiceModule;
import com.twistedeqations.dagger2tutorial.di.module.PicassoModule;
import com.twistedeqations.dagger2tutorial.network.GithubService;

import dagger.Component;

/**
 * Created by Lenovo on 30.11.2016.
 */

@Component(modules = {GithubServiceModule.class, PicassoModule.class})
public interface GithubApplicationComponent {

    Picasso getPicasso();

    GithubService getGithubService();
}
