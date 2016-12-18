package com.crespro.myamaltutor.Pengenalan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crespro.myamaltutor.MenuActivity;
import com.crespro.myamaltutor.R;

public class Pengenalan1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan1);
    }

    public void onClickbackp1(View view) {
        Intent intent = new Intent(Pengenalan1.this, MenuActivity.class);
        startActivity(intent);
    }

    public void onClicknextp1(View view) {
        Intent intent = new Intent(Pengenalan1.this, Pengenalan2.class);
        startActivity(intent);
    }

}
