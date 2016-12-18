package com.crespro.myamaltutor.Kira2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.Score.ScoreMingguan2Activity;
import com.crespro.myamaltutor.database.DatabaseService;
import com.crespro.myamaltutor.model.Amal;

import io.realm.Realm;

public class SenaraiAmal2b extends AppCompatActivity {

    private CheckBox checkBox_jemaah2, checkBox_quran2, checkBox_zikir2, checkBox_dhuha2, checkBox_istighfar2,
            checkBox_qiamullail2, checkBox_puasa2, checkBox_mathurat2, checkBox_belajar2, checkBox_riadah2;
    private Button total2;
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
        amal2.setId(4);
        amal2.setLevel(2);
        amal2.setWeek(2); // 1 is for week one
        amal2.setScore(sum / 10 * 100); // score value
        DatabaseService.getInstance().copyOrUpdateAmal(mRealm2, amal2); // save amal into database

        mScoreMingguan2Btn.setVisibility(View.VISIBLE);
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



