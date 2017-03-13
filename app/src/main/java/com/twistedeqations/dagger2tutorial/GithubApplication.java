package com.twistedeqations.dagger2tutorial;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.twistedeqations.dagger2tutorial.di.component.DaggerGithubApplicationComponent;
import com.twistedeqations.dagger2tutorial.di.component.GithubApplicationComponent;
import com.twistedeqations.dagger2tutorial.di.module.ContextModule;
import com.twistedeqations.dagger2tutorial.network.DateTimeConverter;
import com.twistedeqations.dagger2tutorial.network.GithubService;

import org.joda.time.DateTime;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

import static com.fatboyindustrial.gsonjodatime.Converters.DATE_TIME_TYPE;

public class GithubApplication extends Application {

    public static GithubApplication get(Activity activity) {
        return (GithubApplication) activity.getApplication();
    }

    GithubApplicationComponent component;
    private GithubService githubService;
    private Picasso picasso;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());


        //DaggerGithubApplicationComponent sınıfı auto-generated classtır
        //sadece ContextModule set etmemizin sebebi ise : Constructorının parametre alması
        //Constructorı parametre almayan moduleleri newlemeye gerek yok, Dagger kendisi newliyor.

        component = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        //Bu get methodlar kullanılmıyor.
        //Fakat uygulama getter methodlar yazılarak uygulama genelinde kullanılması sağlanabilir.
        githubService = component.getGithubService();
        picasso = component.getPicasso();

    }

    public GithubApplicationComponent githubApplicationComponent(){
        return  component;
    }
}