package com.destivar89.randomusers.infrastructure;


import android.app.Application;

import io.realm.Realm;

public class RandomUsersApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
    }
}
