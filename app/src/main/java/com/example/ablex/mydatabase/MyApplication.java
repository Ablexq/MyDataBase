package com.example.ablex.mydatabase;

import android.app.Application;

import com.facebook.stetho.Stetho;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

        Realm.init(this);
        //realm使用默认配置
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        //realm使用自定义配置
//        RealmConfiguration config = new  RealmConfiguration.Builder()
//                .name("myRealm.realm")
//                .deleteRealmIfMigrationNeeded()
//                .build();
        Realm.setDefaultConfiguration(config);

    }
}
