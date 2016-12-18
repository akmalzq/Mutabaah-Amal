package com.crespro.myamaltutor.MyAmalMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.SenaraiMinggu.SenaraiMinggu2;

public class TahapDuaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahap_dua);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onClickKiraAmal2(View view) {
        Intent intent = new Intent(TahapDuaActivity.this, SenaraiMinggu2.class);
        startActivity(intent);

    }

}
