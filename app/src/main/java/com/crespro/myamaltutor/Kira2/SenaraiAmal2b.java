package com.crespro.myamaltutor.Kira2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.Score.ScoreMingguan2Activity;
import com.crespro.myamaltutor.database.DatabaseService;
import com.crespro.myamaltutor.model.Amal;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class SenaraiAmal2b extends AppCompatActivity {

    CheckBox checkBox_jemaah2, checkBox_quran2, checkBox_zikir2, checkBox_dhuha2, checkBox_istighfar2,
            checkBox_qiamullail2, checkBox_puasa2, checkBox_mathurat2, checkBox_belajar2, checkBox_riadah2;
    Button total2;
    private Button mScoreMingguan2Btn;
    private Realm mRealm2;

    int sum = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // NOTE: initialize realm
        mRealm2 = Realm.getDefaultInstance();

        setContentView(R.layout.activity_senarai_amal2);
        checkBox_jemaah2 = (CheckBox) findViewById(R.id.checkBox_jemaah2);

        checkBox_quran2 = (CheckBox) findViewById(R.id.checkBox_quran2);

        checkBox_zikir2 = (CheckBox) findViewById(R.id.checkBox_zikir2);

        checkBox_dhuha2 = (CheckBox) findViewById(R.id.checkBox_dhuha2);

        checkBox_istighfar2 = (CheckBox) findViewById(R.id.checkBox_istighfar2);

        checkBox_qiamullail2 = (CheckBox) findViewById(R.id.checkBox_qiamullail2);

        checkBox_puasa2 = (CheckBox) findViewById(R.id.checkBox_puasa2);

        checkBox_mathurat2 = (CheckBox) findViewById(R.id.checkBox_mathurat2);

        checkBox_belajar2 = (CheckBox) findViewById(R.id.checkBox_belajar2);

        checkBox_riadah2 = (CheckBox) findViewById(R.id.checkBox_riadah2);

        mScoreMingguan2Btn = (Button) findViewById(R.id.score_mingguan2_btn);

        mScoreMingguan2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SenaraiAmal2b.this, ScoreMingguan2Activity.class));
            }
        });

        total2 = (Button) findViewById(R.id.total2);


        total2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculations();

            }

        });


    }

    private void makeCalculations() {

        float sum = 0;


        if (((CheckBox) findViewById(R.id.checkBox_jemaah2)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_quran2)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_zikir2)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_dhuha2)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_istighfar2)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_qiamullail2)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_puasa2)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_mathurat2)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_belajar2)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_riadah2)).isChecked()) sum += 1;


        total2.setText(String.format("Prestasi Amal Anda Minggu ini adalah  : %.2f", +sum / 10 * 100));

        Amal amal2 = new Amal();
        amal2.setLevel2(2);
        amal2.setWeek2(2); // 1 is for week one
        amal2.setScore2(sum / 10 * 100); // score value
        DatabaseService.getInstance().copyOrUpdateAmal(mRealm2, amal2); // save amal into database

        // to get back the amal from database
        getAmal();
        getAmalByWeek();
        getAmals();

        mScoreMingguan2Btn.setVisibility(View.VISIBLE);
    }

    /**
     * Get amal from first row of the database
     */
    private void getAmal() {
        Amal amal2 = DatabaseService.getInstance().getAmal(mRealm2);
        Log.d("AMAL LOG", "MINGGU: " + amal2.getWeek2());
        Log.d("AMAL LOG", "SKOR: " + amal2.getScore2());
    }

    /**
     * Get amal by week. You can change the week based on you need and get the result (score)
     * that belongs to that particular week
     */
    private void getAmalByWeek() {
        int week2 = 1;
        Amal amal2 = DatabaseService.getInstance().getAmalByWeek(mRealm2, week2);
        Log.d("AMAL LOG", "MINGGU: " + amal2.getWeek2());
        Log.d("AMAL LOG", "SKOR: " + amal2.getScore2());

    }

    /**
     * Get all amals from database. It will iterate based on you amal database size.
     */
    private void getAmals() {
        RealmResults<Amal> amalList2 = DatabaseService.getInstance().getAmals(mRealm2);
        RealmList<Amal> amals2 = new RealmList<>();
        for (Amal amal2 : amalList2) {
            amals2.add(amal2);
        }

        for (int i = 1; i < amals2.size(); i++) {
            Log.d("AMAL LOG", "MINGGU: " + amals2.get(i).getWeek2());
            Log.d("AMAL LOG", "SKOR: %.2f" + amals2.get(i).getScore2());
        }
    }

    @Override
    protected void onDestroy() {
        // NOTE: close realm on every single activity/fragment to avoid crash
        if (mRealm2 != null) {
            mRealm2.close();
        }
        super.onDestroy();
    }
}



