package com.crespro.myamaltutor.MyAmalMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.SenaraiMinggu.SenaraiMinggu1;

public class TahapSatuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahap_satu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onClickKiraAmal1(View view) {
        Intent intent = new Intent(TahapSatuActivity.this, SenaraiMinggu1.class);
        startActivity(intent);
    }
}