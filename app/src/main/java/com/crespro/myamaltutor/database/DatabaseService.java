package com.crespro.myamaltutor.database;

import com.crespro.myamaltutor.model.Amal;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by nikmuhammadamin on 03/12/2016.
 */

public class DatabaseService {

    private static DatabaseService sInstance = null;

    public static synchronized DatabaseService getInstance() {
        if (sInstance == null) {
            synchronized ((DatabaseService.class)) {
                if (sInstance == null) {
                    sInstance = new DatabaseService();
                }
            }
        }

        return sInstance;
    }

    public void copyOrUpdateAmal(final Realm realm, final Amal amal) {
        realm.beginTransaction();
        //realm.delete(Amal.class);
        realm.copyToRealmOrUpdate(amal);
        realm.commitTransaction();
    }

    // get amal for first data in the row
    public Amal getAmal(final Realm realm) {
        return realm.where(Amal.class).findFirst();
    }

    // get amal by week
    public Amal getAmalByWeek(final Realm realm, final int week) {
        return realm.where(Amal.class).equalTo("week", week).findFirst();
    }

    // get all amals by week
    public RealmResults<Amal> getAmalsByLevel(final Realm realm, final int level) {
        return realm.where(Amal.class).equalTo("level", level).findAll();
    }

    // get all amal
    public RealmResults<Amal> getAmals(final Realm realm) {
        return realm.where(Amal.class).findAll();
    }
}
