package com.crespro.myamaltutor.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crespro.myamaltutor.R;
import com.crespro.myamaltutor.model.Amal;

import io.realm.RealmList;

/**
 * Created by nikmuhammadamin on 04/12/2016.
 */

public class ScoreMingguanAdapter2 extends RecyclerView.Adapter<ScoreMingguanAdapter2.ScoreViewHolder> {

    private RealmList<Amal> mAmalList2;

    public ScoreMingguanAdapter2(RealmList<Amal> mAmalList2) {
        this.mAmalList2 = mAmalList2;
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_score_mingguan2, null);
        return new ScoreViewHolder(view2);
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int position) {

        holder.mWeek2.setText("Week : " + mAmalList2.get(position).getWeek() + "");
        holder.mScore2.setText("Score : " + mAmalList2.get(position).getScore() + "");
    }

    @Override
    public int getItemCount() {
        return mAmalList2.size();
    }

    class ScoreViewHolder extends RecyclerView.ViewHolder {

        private TextView mWeek2;
        private TextView mScore2;


        public ScoreViewHolder(View itemView2) {
            super(itemView2);

            mWeek2 = (TextView) itemView2.findViewById(R.id.week2);
            mScore2 = (TextView) itemView2.findViewById(R.id.score2);

        }
    }
}
