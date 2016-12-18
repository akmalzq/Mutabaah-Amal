package com.crespro.myamaltutor;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by nikmuhammadamin on 03/12/2016.
 */

public class MutabaahApplication extends Application {

    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        initRealmConfiguration();
    }

    private void initRealmConfiguration() {

        // When you create a RealmConfiguration you can specify the version of the schema.
        // If the schema does not have that version a RealmMigrationNeededException will be thrown.
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("default.realm")
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
