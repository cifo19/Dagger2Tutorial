package com.twistedeqations.dagger2tutorial.di.component;

import com.twistedeqations.dagger2tutorial.screens.DetailActivity;
import com.twistedeqations.dagger2tutorial.screens.HomeActivity;

/**
 * Created by cafer on 14.2.2018.
 */

public interface ActivityInjector {
    void inject(HomeActivity homeActivity);
    void inject(DetailActivity detailActivity);
}
