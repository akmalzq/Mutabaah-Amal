package com.crespro.myamaltutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.crespro.myamaltutor.MainMenu.LamanIlmu;
import com.crespro.myamaltutor.MainMenu.MyAmalMenu;
import com.crespro.myamaltutor.MainMenu.PanduanAmalanMenu;
import com.crespro.myamaltutor.Pengenalan.Pengenalan1;

public class MenuActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




    }


    //coding utk bila klik akan muncul interface Tahap 1
    public void onClickPengenalan(View view) {
        Intent intent = new Intent(MenuActivity.this, Pengenalan1.class);
        startActivity(intent);
    }

    //coding utk bila klik akan muncul interface Tahap 1
    public void onClickPanduanAmalan(View view) {
        Intent intent = new Intent(MenuActivity.this, PanduanAmalanMenu.class);
        startActivity(intent);
    }


    //coding utk bila klik akan muncul interface Tahap 3
    public void onClickMyAmalAnda(View view) {
        Intent intent = new Intent(MenuActivity.this, MyAmalMenu.class);
        startActivity(intent);
    }

    //coding utk bila klik akan muncul interface Tazkirah
    public void onClickTazkirah(View view) {
        Intent intent = new Intent(MenuActivity.this, LamanIlmu.class);
        startActivity(intent);
    }





}
