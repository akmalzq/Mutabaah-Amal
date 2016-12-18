package com.crespro.myamaltutor.Kira2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.Score.ScoreMingguan3Activity;
import com.crespro.myamaltutor.database.DatabaseService;
import com.crespro.myamaltutor.model.Amal;

import io.realm.Realm;

public class SenaraiAmal3 extends AppCompatActivity {

    CheckBox checkBox_jemaah3, checkBox_quran3, checkBox_zikir3, checkBox_dhuha3, checkBox_istighfar3,
            checkBox_qiamullail3, checkBox_puasa3, checkBox_mathurat3, checkBox_belajar3, checkBox_riadah3;
    Button total3;
    private Button mScoreMingguan3Btn;
    private Realm mRealm3;

    int sum = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // NOTE: initialize realm
        mRealm3 = Realm.getDefaultInstance();

        setContentView(R.layout.activity_senarai_amal3);
        checkBox_jemaah3 = (CheckBox) findViewById(R.id.checkBox_jemaah3);

        checkBox_quran3 = (CheckBox) findViewById(R.id.checkBox_quran3);

        checkBox_zikir3 = (CheckBox) findViewById(R.id.checkBox_zikir3);

        checkBox_dhuha3 = (CheckBox) findViewById(R.id.checkBox_dhuha3);

        checkBox_istighfar3 = (CheckBox) findViewById(R.id.checkBox_istighfar3);

        checkBox_qiamullail3 = (CheckBox) findViewById(R.id.checkBox_qiamullail3);

        checkBox_puasa3 = (CheckBox) findViewById(R.id.checkBox_puasa3);

        checkBox_mathurat3 = (CheckBox) findViewById(R.id.checkBox_mathurat3);

        checkBox_belajar3 = (CheckBox) findViewById(R.id.checkBox_belajar3);

        checkBox_riadah3 = (CheckBox) findViewById(R.id.checkBox_riadah3);

        mScoreMingguan3Btn = (Button) findViewById(R.id.score_mingguan3_btn);

        mScoreMingguan3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SenaraiAmal3.this, ScoreMingguan3Activity.class));
            }
        });

        total3 = (Button) findViewById(R.id.total3);


        total3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculations();

            }

        });


    }

    private void makeCalculations() {

        float sum = 0;


        if (((CheckBox) findViewById(R.id.checkBox_jemaah3)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_quran3)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_zikir3)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_dhuha3)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_istighfar3)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_qiamullail3)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_puasa3)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_mathurat3)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_belajar3)).isChecked()) sum += 1;
        if (((CheckBox) findViewById(R.id.checkBox_riadah3)).isChecked()) sum += 1;


        total3.setText(String.format("Prestasi Amal Anda Minggu ini adalah  : %.2f", +sum / 10 * 100));
        Amal amal3 = new Amal();
        amal3.setId(5);
        amal3.setLevel(3);
        amal3.setWeek(1); // 1 is for week one
        amal3.setScore(sum / 10 * 100); // score value
        DatabaseService.getInstance().copyOrUpdateAmal(mRealm3, amal3); // save amal into database

        mScoreMingguan3Btn.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        // NOTE: close realm on every single activity/fragment to avoid crash
        if (mRealm3 != null) {
            mRealm3.close();
        }
        super.onDestroy();
    }
}



