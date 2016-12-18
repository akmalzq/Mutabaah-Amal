package com.crespro.myamaltutor.SenaraiMinggu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.crespro.myamaltutor.Kira2.SenaraiAmal1;
import com.crespro.myamaltutor.Kira2.SenaraiAmal1b;
import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.Score.ScoreMingguanActivity;

public class SenaraiMinggu1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senarai_minggu1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onClickMinggu1(View view) {
        Intent intent = new Intent(SenaraiMinggu1.this, SenaraiAmal1.class);
        startActivity(intent);
    }

    public void onClickMinggu1b(View view) {
        Intent intent = new Intent(SenaraiMinggu1.this, SenaraiAmal1b.class);
        startActivity(intent);
    }

    public void onClickSkor1(View view) {
        Intent intent = new Intent(SenaraiMinggu1.this, ScoreMingguanActivity.class);
        startActivity(intent);

    }

}
