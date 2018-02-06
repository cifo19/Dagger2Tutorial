package com.twistedeqations.dagger2tutorial.di.component;

import com.squareup.picasso.Picasso;
import com.twistedeqations.dagger2tutorial.di.module.GithubServiceModule;
import com.twistedeqations.dagger2tutorial.di.module.PicassoModule;
import com.twistedeqations.dagger2tutorial.di.scope.GithubApplicationScope;
import com.twistedeqations.dagger2tutorial.network.GithubService;

import dagger.Component;

/**
 * Created by Lenovo on 30.11.2016.
 */

@GithubApplicationScope
@Component(modules = {GithubServiceModule.class, PicassoModule.class})
public interface GithubApplicationComponent {

    //Dagger bu getter methodların dönüş değeri tipinde (Picasso ve GithubService)
    //nesnelere ulaşabileceğimiz generated kodlar oluşturur

    //Bu getter methodları kullanarak generate edilmiş nesnelere ulaşabiliriz.

    //Buraya getter methodlar yazılmaz ise dagger dışarıdan nesnelere ulaşabileceğimiz
    //methodlar generate etemez.

    Picasso getPicasso();

    GithubService getGithubService();
}
