package com.crespro.myamaltutor.SenaraiMinggu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.crespro.myamaltutor.Kira2.SenaraiAmal2;
import com.crespro.myamaltutor.Kira2.SenaraiAmal2b;
import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.Score.ScoreMingguan2Activity;

public class SenaraiMinggu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senarai_minggu2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onClickMinggu2 (View view) {
        Intent intent = new Intent(SenaraiMinggu2.this, SenaraiAmal2.class);
        startActivity(intent);
    }

    public void onClickMinggu2b (View view) {
        Intent intent = new Intent(SenaraiMinggu2.this, SenaraiAmal2b.class);
        startActivity(intent);
    }
    public void onClickSkor2(View view) {
        Intent intent = new Intent(SenaraiMinggu2.this, ScoreMingguan2Activity.class);
        startActivity(intent);

    }
}