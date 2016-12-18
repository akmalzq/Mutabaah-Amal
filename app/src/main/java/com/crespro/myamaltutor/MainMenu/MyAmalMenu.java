package com.crespro.myamaltutor.MainMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crespro.myamaltutor.MyAmalMenu.TahapDuaActivity;
import com.crespro.myamaltutor.MyAmalMenu.TahapSatuActivity;
import com.crespro.myamaltutor.MyAmalMenu.TahapTigaActivity;

import com.crespro.myamaltutor.R;

public class MyAmalMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_amal_menu);


    }

    public void onClickTahap1(View view) {
        Intent intent = new Intent(MyAmalMenu.this, TahapSatuActivity.class);
        startActivity(intent);
    }
    public void onClickTahap2(View view) {
        Intent intent = new Intent(MyAmalMenu.this, TahapDuaActivity.class);
        startActivity(intent);
    }

    public void onClickTahap3(View view) {
        Intent intent = new Intent(MyAmalMenu.this, TahapTigaActivity.class);
        startActivity(intent);
    }
}