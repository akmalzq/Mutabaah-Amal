package com.crespro.myamaltutor.SenaraiMinggu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.crespro.myamaltutor.Kira2.SenaraiAmal3;
import com.crespro.myamaltutor.Kira2.SenaraiAmal3b;
import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.Score.ScoreMingguan3Activity;

public class SenaraiMinggu3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senarai_minggu3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void onClickMinggu3 (View view) {
        Intent intent = new Intent(SenaraiMinggu3.this, SenaraiAmal3.class);
        startActivity(intent);
    }

    public void onClickMinggu3b (View view) {
        Intent intent = new Intent(SenaraiMinggu3.this, SenaraiAmal3b.class);
        startActivity(intent);
    }
    public void onClickSkor3(View view) {
        Intent intent = new Intent(SenaraiMinggu3.this, ScoreMingguan3Activity.class);
        startActivity(intent);

    }

}
