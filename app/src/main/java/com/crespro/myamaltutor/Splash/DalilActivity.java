package com.crespro.myamaltutor.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.crespro.myamaltutor.MenuActivity;
import com.crespro.myamaltutor.R;

public class DalilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dalil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //muncul interface dalil sebentar
        Thread splashscreen = new Thread() {
            @Override
            public void run() {
                try{
                    sleep(2000);

                }catch (InterruptedException e){
                    e.printStackTrace();

                }finally {
                    Intent intent = new Intent(DalilActivity.this, MenuActivity.class);
                    startActivity(intent);

                }


            }
        }; splashscreen.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
