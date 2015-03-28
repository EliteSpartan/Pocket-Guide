package com.chiller.apps.materialtest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chiller.apps.materialtest.R;
import com.chiller.apps.materialtest.minecraft.MinecraftPC;

/**
 * Created by Anthony on 28/03/2015.
 */
public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {

    private String[] mTitles;
    // private Integer[] mImageID;

    public GamesAdapter(String[] mTitles) { // Integer[] mImageID

        this.mTitles = mTitles;
        // this.mImageID = mImageID
    }

    @Override
    public GamesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_games_item, viewGroup, false);
        return new GamesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GamesViewHolder gamesViewHolder, int position) {

        gamesViewHolder.viewName.setText(mTitles[position]);
        // gamesViewHolder.viewPicture.setImageResource(mImageID[position]);
    }

    @Override
    public int getItemCount() {

        return mTitles.length;
    }

    public static class GamesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView viewName;
        // public ImageView viewPicture;
        private final Context context;

        public GamesViewHolder(View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);
            context = itemView.getContext();

            viewName = (TextView) itemView.findViewById(R.id.card_text);
            // viewPicture = (ImageView) itemView.findViewById(R.id.card_image);
        }

        @Override
        public void onClick(View v) {

            Intent intent;
            switch (getPosition()){
                case 0:
                    intent = new Intent(context, MinecraftPC.class);
                    break;
                default:
                    intent = new Intent(context, MinecraftPC.class);
                    break;
            }
            context.startActivity(intent);

        }
    }
}
