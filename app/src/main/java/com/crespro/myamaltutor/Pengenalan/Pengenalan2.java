package com.crespro.myamaltutor.Pengenalan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crespro.myamaltutor.R;

public class Pengenalan2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan2);

    }

    public void onClickbackp2(View view) {
        Intent intent = new Intent(Pengenalan2.this, Pengenalan1.class);
        startActivity(intent);
    }
    public void onClicknextp2(View view) {
        Intent intent = new Intent(Pengenalan2.this, Pengenalan3.class);
        startActivity(intent);
    }
}
