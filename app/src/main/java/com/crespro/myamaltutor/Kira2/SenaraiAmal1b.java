package com.crespro.myamaltutor.Kira2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.Score.ScoreMingguanActivity;
import com.crespro.myamaltutor.database.DatabaseService;
import com.crespro.myamaltutor.model.Amal;

import io.realm.Realm;

public class SenaraiAmal1b extends Activity {

    private CheckBox mCheckBoxJemaah1;
    private CheckBox mCheckBoxQuran1;
    private CheckBox mCheckBoxZikir1;
    private CheckBox mCheckBoxDhuha1;
    private CheckBox mCheckBoxIstighfar1;
    private CheckBox mCheckBoxBelajar1;
    private CheckBox mCheckBoxRiadah1;
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
        mCheckBoxJemaah1 = (CheckBox) findViewById(R.id.checkBox_jemaah1);

        mCheckBoxQuran1 = (CheckBox) findViewById(R.id.checkBox_quran1);

        mCheckBoxZikir1 = (CheckBox) findViewById(R.id.checkBox_zikir1);

        mCheckBoxDhuha1 = (CheckBox) findViewById(R.id.checkBox_dhuha1);

        mCheckBoxIstighfar1 = (CheckBox) findViewById(R.id.checkBox_istighfar1);

        mCheckBoxBelajar1 = (CheckBox) findViewById(R.id.checkBox_belajar1);

        mCheckBoxRiadah1 = (CheckBox) findViewById(R.id.checkBox_riadah1);

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
        amal.setId(2);
        amal.setLevel(1);
        amal.setWeek(2); // 1 is for week one
        amal.setScore(sum / 7 * 100); // score value
        DatabaseService.getInstance().copyOrUpdateAmal(mRealm, amal); // save amal into database

        mScoreMingguanBtn.setVisibility(View.VISIBLE);
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

