package com.crespro.myamaltutor.Pengenalan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crespro.myamaltutor.R;

public class Pengenalan3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan3);


    }
    public void onClickbackp3(View view) {
        Intent intent = new Intent(Pengenalan3.this, Pengenalan2.class);
        startActivity(intent);
    }

    public void onClicknextp3(View view) {
        Intent intent = new Intent(Pengenalan3.this, Pengenalan4.class);
        startActivity(intent);
    }

}
