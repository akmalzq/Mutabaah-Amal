package com.crespro.myamaltutor.MyAmalMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.SenaraiMinggu.SenaraiMinggu3;

public class TahapTigaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahap_tiga);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onClickKiraAmal3(View view) {
        Intent intent = new Intent(TahapTigaActivity.this, SenaraiMinggu3.class);
        startActivity(intent);
    }
}
