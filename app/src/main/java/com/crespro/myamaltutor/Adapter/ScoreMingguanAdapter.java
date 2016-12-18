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

public class ScoreMingguanAdapter extends RecyclerView.Adapter<ScoreMingguanAdapter.ScoreViewHolder> {

    private RealmList<Amal> mAmalList;

    public ScoreMingguanAdapter(RealmList<Amal> mAmalList) {
        this.mAmalList = mAmalList;
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_score_mingguan, null);
        return new ScoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int position) {

        holder.mWeek.setText("Week: " + mAmalList.get(position).getWeek() + "");
        holder.mScore.setText("Score: " + mAmalList.get(position).getScore() + "");
    }

    @Override
    public int getItemCount() {
        return mAmalList.size();
    }

    class ScoreViewHolder extends RecyclerView.ViewHolder {

        private TextView mLevel;
        private TextView mWeek;
        private TextView mScore;

        public ScoreViewHolder(View itemView) {
            super(itemView);


            mWeek = (TextView) itemView.findViewById(R.id.week);
            mScore = (TextView) itemView.findViewById(R.id.score);
        }
    }
}
