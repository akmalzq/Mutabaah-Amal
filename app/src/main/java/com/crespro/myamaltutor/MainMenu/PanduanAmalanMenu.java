package com.crespro.myamaltutor.MainMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.SenaraiMinggu.KelebihanAmal;

public class PanduanAmalanMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan_amalan_menu);


    }

    public void onClickKelebihan(View view) {
        Intent intent = new Intent(PanduanAmalanMenu.this, KelebihanAmal.class);
        startActivity(intent);
    }
}
