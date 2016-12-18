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
 * Created by User on 14/12/2016.
 */
public class ScoreMingguanAdapter3 extends RecyclerView.Adapter<ScoreMingguanAdapter3.ScoreViewHolder> {

    private RealmList<Amal> mAmalList3;

    public ScoreMingguanAdapter3(RealmList<Amal> mAmalList3) {
        this.mAmalList3 = mAmalList3;
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_score_mingguan3, null);
        return new ScoreViewHolder(view3);
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int position) {

        holder.mWeek3.setText("Week : " + mAmalList3.get(position).getWeek3());
        holder.mScore3.setText("Score : " + mAmalList3.get(position).getScore3() + "");
    }

    @Override
    public int getItemCount() {
        return mAmalList3.size();
    }

    class ScoreViewHolder extends RecyclerView.ViewHolder {

        private TextView mWeek3;
        private TextView mScore3;


        public ScoreViewHolder(View itemView3) {
            super(itemView3);

            mWeek3 = (TextView) itemView3.findViewById(R.id.week3);
            mScore3 = (TextView) itemView3.findViewById(R.id.score3);

        }
    }
}
