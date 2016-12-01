package com.twistedeqations.dagger2tutorial.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Lenovo on 1.12.2016.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface GithubApplicationScope {
}
