package com.destivar89.randomusers.infrastructure.di.common;

import android.app.Activity;

import com.destivar89.randomusers.presentation.common.navigator.Navigator;
import com.destivar89.randomusers.presentation.common.navigator.NavigatorImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseModule {

    private Activity activityContext;

    public BaseModule(Activity activityContext){
        this.activityContext = activityContext;
    }

    @Provides
    Activity providesActivityContext(){
        return activityContext;
    }

    @Provides
    Navigator provideNavigator(NavigatorImpl navigator){
        return navigator;
    }

}