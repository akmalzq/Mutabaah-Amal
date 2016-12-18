package com.crespro.myamaltutor.SenaraiMinggu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.crespro.myamaltutor.MainMenu.LamanIlmu;
import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.Kelebihan.TazkirahSatu;

public class KelebihanAmal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelebihan_amal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    //coding utk bila klik akan muncul interface Tazkirah 1
    public void onTazkirah1(View view) {
        Intent intent = new Intent(KelebihanAmal.this, TazkirahSatu.class);
        startActivity(intent);
    }

    //coding utk bila klik akan muncul interface Tazkirah 2
    public void onTazkirah2(View view) {
        Intent intent = new Intent(KelebihanAmal.this, LamanIlmu.class);
        startActivity(intent);
    }

}
