package com.crespro.myamaltutor.Score;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.crespro.myamaltutor.Adapter.ScoreMingguanAdapter;
import com.crespro.myamaltutor.MenuActivity;
import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.database.DatabaseService;
import com.crespro.myamaltutor.model.Amal;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by nikmuhammadamin on 04/12/2016.
 */

public class ScoreMingguanActivity extends Activity {

    private Realm mRealm;
    private ScoreMingguanAdapter mAdapter;
    private RecyclerView mRecyclerView;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_mingguan);


        mRealm = Realm.getDefaultInstance();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        RealmResults<Amal> amalList = DatabaseService.getInstance().getAmals(mRealm);
        RealmList<Amal> amals = new RealmList<>();
        for (Amal amal : amalList) {
            amals.add(amal);
        }

        Log.d("AAA", "score size : " + amals.size());
        mAdapter = new ScoreMingguanAdapter(amals);
        mAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy() {
        if (mRealm != null) {
            mRealm.close();
        }
        super.onDestroy();
    }

    public void onClickHome(View view) {
        Intent intent = new Intent(ScoreMingguanActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}