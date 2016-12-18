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

public class SenaraiAmal2 extends AppCompatActivity {

    private CheckBox mCheckBoxJemaah2;
    private CheckBox mCheckBoxQuran2;
    private CheckBox mCheckBoxZikir2;
    private CheckBox mCheckBoxDhuha2;
    private CheckBox mCheckBoxIstighfar2;
    private CheckBox mCheckBoxQiamullail2;
    private CheckBox mCheckBoxPuasa2;
    private CheckBox mCheckBoxMathurat2;
    private CheckBox mCheckBoxBelajar2;
    private CheckBox mCheckBoxRiadah2;
    private Button mTotal2Btn;
    private Button mScoreMingguan2Btn;
    private Realm mRealm2;

    private int sum = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // NOTE: initialize realm
        mRealm2 = Realm.getDefaultInstance();

        setContentView(R.layout.activity_senarai_amal2);
        mCheckBoxJemaah2 = (CheckBox) findViewById(R.id.checkBox_jemaah2);

        mCheckBoxQuran2 = (CheckBox) findViewById(R.id.checkBox_quran2);

        mCheckBoxZikir2 = (CheckBox) findViewById(R.id.checkBox_zikir2);

        mCheckBoxDhuha2 = (CheckBox) findViewById(R.id.checkBox_dhuha2);

        mCheckBoxIstighfar2 = (CheckBox) findViewById(R.id.checkBox_istighfar2);

        mCheckBoxQiamullail2 = (CheckBox) findViewById(R.id.checkBox_qiamullail2);

        mCheckBoxPuasa2 = (CheckBox) findViewById(R.id.checkBox_puasa2);

        mCheckBoxMathurat2 = (CheckBox) findViewById(R.id.checkBox_mathurat2);

        mCheckBoxBelajar2 = (CheckBox) findViewById(R.id.checkBox_belajar2);

        mCheckBoxRiadah2 = (CheckBox) findViewById(R.id.checkBox_riadah2);

        mScoreMingguan2Btn = (Button) findViewById(R.id.score_mingguan2_btn);

        mScoreMingguan2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SenaraiAmal2.this, ScoreMingguan2Activity.class));
            }
        });

        mTotal2Btn = (Button) findViewById(R.id.total2);


        mTotal2Btn.setOnClickListener(new View.OnClickListener() {
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


        mTotal2Btn.setText(String.format("Prestasi Amal Anda Minggu ini adalah  : %.2f", +sum / 10 * 100));

        Amal amal2 = new Amal();
        amal2.setLevel(2); // 2 is for level 2
        amal2.setWeek(1); // 1 is for week 1g
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



