package com.crespro.myamaltutor.Score;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.crespro.myamaltutor.Adapter.ScoreMingguanAdapter2;
import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.database.DatabaseService;
import com.crespro.myamaltutor.model.Amal;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by nikmuhammadamin on 04/12/2016.
 */

public class ScoreMingguan2Activity extends Activity {

    private Realm mRealm2;
    private ScoreMingguanAdapter2 mAdapter2;
    private RecyclerView mRecyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_mingguan2);

        mRealm2 = Realm.getDefaultInstance();

        mRecyclerView2 = (RecyclerView) findViewById(R.id.recycler2);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(this));

        RealmResults<Amal> amalList2 = DatabaseService.getInstance().getAmalsByLevel(mRealm2, 2); // 2 is for level 2
        RealmList<Amal> amals2 = new RealmList<>();
        for (Amal amal2 : amalList2) {
            amals2.add(amal2);
        }

        mAdapter2 = new ScoreMingguanAdapter2(amals2);
        mAdapter2.notifyDataSetChanged();
        mRecyclerView2.setAdapter(mAdapter2);
    }

    @Override
    protected void onDestroy() {
        if (mRealm2 != null) {
            mRealm2.close();
        }
        super.onDestroy();
    }
}
