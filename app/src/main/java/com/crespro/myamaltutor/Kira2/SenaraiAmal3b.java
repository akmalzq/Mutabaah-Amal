package com.crespro.myamaltutor.Kira2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.Score.ScoreMingguan3Activity;
import com.crespro.myamaltutor.database.DatabaseService;
import com.crespro.myamaltutor.model.Amal;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class SenaraiAmal3b extends AppCompatActivity {

        CheckBox checkBox_jemaah3, checkBox_quran3, checkBox_zikir3, checkBox_dhuha3, checkBox_istighfar3,
                checkBox_qiamullail3, checkBox_puasa3, checkBox_mathurat3, checkBox_belajar3, checkBox_riadah3;
        Button total3;
        private Button mScoreMingguan3Btn;
        private Realm mRealm3;

        int sum=0;

        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                // NOTE: initialize realm
                mRealm3 = Realm.getDefaultInstance();

                setContentView(R.layout.activity_senarai_amal3);
                checkBox_jemaah3 = (CheckBox) findViewById(R.id.checkBox_jemaah3);

                checkBox_quran3 = (CheckBox) findViewById(R.id.checkBox_quran3);

                checkBox_zikir3 = (CheckBox) findViewById(R.id.checkBox_zikir3);

                checkBox_dhuha3 = (CheckBox) findViewById(R.id.checkBox_dhuha3);

                checkBox_istighfar3 = (CheckBox) findViewById(R.id.checkBox_istighfar3);

                checkBox_qiamullail3 = (CheckBox) findViewById(R.id.checkBox_qiamullail3);

                checkBox_puasa3 = (CheckBox) findViewById(R.id.checkBox_puasa3);

                checkBox_mathurat3 = (CheckBox) findViewById(R.id.checkBox_mathurat3);

                checkBox_belajar3 = (CheckBox) findViewById(R.id.checkBox_belajar3);

                checkBox_riadah3= (CheckBox) findViewById(R.id.checkBox_riadah3);

                mScoreMingguan3Btn = (Button) findViewById(R.id.score_mingguan3_btn);

                mScoreMingguan3Btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                startActivity(new Intent(SenaraiAmal3b.this, ScoreMingguan3Activity.class));
                        }
                });

                total3 = (Button) findViewById(R.id.total3);


                total3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                makeCalculations();

                        }

                });




        }

        private void makeCalculations() {

                float sum = 0;


                if (((CheckBox) findViewById(R.id.checkBox_jemaah3)).isChecked()) sum += 1;
                if (((CheckBox) findViewById(R.id.checkBox_quran3)).isChecked()) sum += 1;
                if (((CheckBox) findViewById(R.id.checkBox_zikir3)).isChecked()) sum += 1;
                if (((CheckBox) findViewById(R.id.checkBox_dhuha3)).isChecked()) sum += 1;
                if (((CheckBox) findViewById(R.id.checkBox_istighfar3)).isChecked()) sum += 1;
                if (((CheckBox) findViewById(R.id.checkBox_qiamullail3)).isChecked()) sum += 1;
                if (((CheckBox) findViewById(R.id.checkBox_puasa3)).isChecked()) sum += 1;
                if (((CheckBox) findViewById(R.id.checkBox_mathurat3)).isChecked()) sum += 1;
                if (((CheckBox) findViewById(R.id.checkBox_belajar3)).isChecked()) sum += 1;
                if (((CheckBox) findViewById(R.id.checkBox_riadah3)).isChecked()) sum += 1;




                total3.setText( String.format("Prestasi Amal Anda Minggu ini adalah  : %.2f",+sum/10*100));
                Amal amal3 = new Amal();
                amal3.setLevel3(1);
                amal3.setWeek3(2); // 1 is for week one
                amal3.setScore3(sum / 10 * 100); // score value
                DatabaseService.getInstance().copyOrUpdateAmal(mRealm3, amal3); // save amal into database

                // to get back the amal from database
                getAmal();
                getAmalByWeek();
                getAmals();

                mScoreMingguan3Btn.setVisibility(View.VISIBLE);
        }

        /**
         * Get amal from first row of the database
         */
        private void getAmal() {
                Amal amal3 = DatabaseService.getInstance().getAmal(mRealm3);
                Log.d("AMAL LOG", "MINGGU: " + amal3.getWeek3());
                Log.d("AMAL LOG", "SKOR: " + amal3.getScore3());
        }

        /**
         * Get amal by week. You can change the week based on you need and get the result (score)
         * that belongs to that particular week
         */
        private void getAmalByWeek() {
                int week3 = 1;
                Amal amal3 = DatabaseService.getInstance().getAmalByWeek(mRealm3, week3);
                Log.d("AMAL LOG", "MINGGU: " + amal3.getWeek3());
                Log.d("AMAL LOG", "SKOR: %.2f" + amal3.getScore3());

        }

        /**
         * Get all amals from database. It will iterate based on you amal database size.
         */
        private void getAmals() {
                RealmResults<Amal> amalList3 = DatabaseService.getInstance().getAmals(mRealm3);
                RealmList<Amal> amals3 = new RealmList<>();
                for (Amal amal3 : amalList3) {
                        amals3.add(amal3);
                }

                for (int i = 1; i < amals3.size(); i++) {
                        Log.d("AMAL LOG", "MINGGU: " + amals3.get(i).getWeek3());
                        Log.d("AMAL LOG", "SKOR: %.2f" + amals3.get(i).getScore3());
                }
        }

        @Override
        protected void onDestroy() {
                // NOTE: close realm on every single activity/fragment to avoid crash
                if (mRealm3 != null) {
                        mRealm3.close();
                }
                super.onDestroy();
        }
}



