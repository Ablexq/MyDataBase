package com.example.ablex.mydatabase;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.ablex.mydatabase.greendao.gen.DaoMaster;
import com.example.ablex.mydatabase.greendao.gen.DaoSession;
import com.facebook.stetho.Stetho;
import com.tencent.mmkv.MMKV;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

    private static DaoSession daoSession;


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

        //配置数据库
        setupDreenDaoDatabase();

        MMKV.initialize(this);

    }

    /**
     * 配置数据库
     */
    private void setupDreenDaoDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shop.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
