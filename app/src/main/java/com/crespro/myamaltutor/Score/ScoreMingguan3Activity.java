package com.crespro.myamaltutor.Score;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.crespro.myamaltutor.Adapter.ScoreMingguanAdapter3;
import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.database.DatabaseService;
import com.crespro.myamaltutor.model.Amal;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by User on 14/12/2016.
 */
public class ScoreMingguan3Activity extends Activity {

    private Realm mRealm3;
    private ScoreMingguanAdapter3 mAdapter3;
    private RecyclerView mRecyclerView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_mingguan3);

        mRealm3 = Realm.getDefaultInstance();

        mRecyclerView3 = (RecyclerView) findViewById(R.id.recycler3);
        mRecyclerView3.setLayoutManager(new LinearLayoutManager(this));

        RealmResults<Amal> amalList3 = DatabaseService.getInstance().getAmalsByLevel(mRealm3, 3);
        RealmList<Amal> amals3 = new RealmList<>();
        for (Amal amal3 : amalList3) {
            amals3.add(amal3);
        }

        mAdapter3 = new ScoreMingguanAdapter3(amals3);
        mAdapter3.notifyDataSetChanged();
        mRecyclerView3.setAdapter(mAdapter3);
    }

    @Override
    protected void onDestroy() {
        if (mRealm3 != null) {
            mRealm3.close();
        }
        super.onDestroy();
    }
}

