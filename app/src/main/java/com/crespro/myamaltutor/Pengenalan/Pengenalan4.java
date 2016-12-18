package com.crespro.myamaltutor.Pengenalan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crespro.myamaltutor.MenuActivity;
import com.crespro.myamaltutor.R;

public class Pengenalan4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan4);

    }

    public void onClickbackp4(View view) {
        Intent intent = new Intent(Pengenalan4.this, Pengenalan3.class);
        startActivity(intent);
    }

    public void onClickhomep(View view) {
        Intent intent = new Intent(Pengenalan4.this, MenuActivity.class);
        startActivity(intent);
    }
}
