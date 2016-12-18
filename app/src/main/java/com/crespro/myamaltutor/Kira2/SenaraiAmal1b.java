package com.crespro.myamaltutor.Kira2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.Score.ScoreMingguanActivity;
import com.crespro.myamaltutor.database.DatabaseService;
import com.crespro.myamaltutor.model.Amal;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class SenaraiAmal1b extends Activity {

    private CheckBox checkBox_jemaah1, checkBox_quran1, checkBox_zikir1, checkBox_dhuha1, checkBox_istighfar1, checkBox_belajar1, checkBox_riadah1;
    private Button total1;
    private Button mScoreMingguanBtn;
    private Realm mRealm;


    int sum = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // NOTE: initialize realm
        mRealm = Realm.getDefaultInstance();

        setContentView(R.layout.activity_senarai_amal1);
        checkBox_jemaah1 = (CheckBox) findViewById(R.id.checkBox_jemaah1);

        checkBox_quran1 = (CheckBox) findViewById(R.id.checkBox_quran1);

        checkBox_zikir1 = (CheckBox) findViewById(R.id.checkBox_zikir1);

        checkBox_dhuha1 = (CheckBox) findViewById(R.id.checkBox_dhuha1);

        checkBox_istighfar1 = (CheckBox) findViewById(R.id.checkBox_istighfar1);

        checkBox_belajar1 = (CheckBox) findViewById(R.id.checkBox_belajar1);

        checkBox_riadah1 = (CheckBox) findViewById(R.id.checkBox_riadah1);

        mScoreMingguanBtn = (Button) findViewById(R.id.score_mingguan_btn);

        mScoreMingguanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SenaraiAmal1b.this, ScoreMingguanActivity.class));
            }
        });

        total1 = (Button) findViewById(R.id.total1);
        total1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculations();
            }
        });
    }


    private void makeCalculations() {
        float sum = 0;

        if (((CheckBox) findViewById(R.id.checkBox_jemaah1)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_quran1)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_zikir1)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_dhuha1)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_istighfar1)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_belajar1)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_riadah1)).isChecked()) sum += 1;

        total1.setText(String.format("Prestasi Amal Anda Minggu ini adalah  : %.2f", +sum / 7 * 100));

        Amal amal = new Amal();
        amal.setLevel(1);
        amal.setWeek(2); // 1 is for week one
        amal.setScore(sum / 7 * 100); // score value
        DatabaseService.getInstance().copyOrUpdateAmal(mRealm, amal); // save amal into database

        // to get back the amal from database
        getAmal();
        getAmalByWeek();
        getAmals();

        mScoreMingguanBtn.setVisibility(View.VISIBLE);
    }

    /**
     * Get amal from first row of the database
     */
    private void getAmal() {
        Amal amal = DatabaseService.getInstance().getAmal(mRealm);
        Log.d("AMAL LOG", "MINGGU: " + amal.getWeek());
        Log.d("AMAL LOG", "SKOR: " + amal.getScore());
    }

    /**
     * Get amal by week. You can change the week based on you need and get the result (score)
     * that belongs to that particular week
     */
    private void getAmalByWeek() {
        int week = 1;
        Amal amal = DatabaseService.getInstance().getAmalByWeek(mRealm, week);
        Log.d("AMAL LOG", "MINGGU: " + amal.getWeek());
        Log.d("AMAL LOG", "SKOR: " + amal.getScore());

    }

    /**
     * Get all amals from database. It will iterate based on you amal database size.
     */
    private void getAmals() {
        RealmResults<Amal> amalList = DatabaseService.getInstance().getAmals(mRealm);
        RealmList<Amal> amals = new RealmList<>();
        for (Amal amal : amalList) {
            amals.add(amal);
        }

        for (int i = 1; i < amals.size(); i++) {
            Log.d("AMAL LOG", "MINGGU: " + amals.get(i).getWeek());
            Log.d("AMAL LOG", "SKOR: %.2f" + amals.get(i).getScore());
        }
    }

    @Override
    protected void onDestroy() {
        // NOTE: close realm on every single activity/fragment to avoid crash
        if (mRealm != null) {
            mRealm.close();
        }
        super.onDestroy();
    }
}

