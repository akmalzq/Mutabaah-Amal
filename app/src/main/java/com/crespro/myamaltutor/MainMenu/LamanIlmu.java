package com.crespro.myamaltutor.MainMenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.crespro.myamaltutor.R;

public class LamanIlmu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laman_ilmu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button btnI = (Button) findViewById(R.id.ili);
        Button btnS = (Button) findViewById(R.id.si);
        Button btnZ = (Button) findViewById (R.id.z);
        Button btnG = (Button) findViewById (R.id.g);

        btnI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("http://iluvislam.my/"));
                startActivity(myWebLink);


            }
        });

        btnS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("http://saifulislam.com/"));
                startActivity(myWebLink);


            }
        });

        btnZ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("http://zulramli.blogspot.my/?m=1"));
                startActivity(myWebLink);


            }
        });

        btnG.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("http://genta-rasa.com/"));
                startActivity(myWebLink);


            }
        });

    }

}