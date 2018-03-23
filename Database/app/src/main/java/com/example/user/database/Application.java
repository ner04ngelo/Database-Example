package com.example.user.database;

import io.realm.Realm;

/**
 * Created by USER on 20/03/2018.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
