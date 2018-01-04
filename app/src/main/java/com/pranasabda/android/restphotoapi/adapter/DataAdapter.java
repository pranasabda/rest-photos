package com.pranasabda.android.restphotoapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pranasabda.android.restphotoapi.R;
import com.pranasabda.android.restphotoapi.models.photoModels;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by prana on 03/01/18.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    public ArrayList<photoModels> values ;
    private Context context;

    public DataAdapter(Context context, ArrayList<photoModels> values){
        this.context = context;
        this.values = values;
    }


    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv_title.setText(values.get(i).getTitle());
        viewHolder.tv_url.setText(values.get(i).getUrl());
        Picasso.with(context).load(values.get(i).getThumbnailUrl()).resize(120, 60).into(viewHolder.img_photos);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title,tv_url;
        private ImageView img_photos;
        public ViewHolder(View view) {
            super(view);

            img_photos = (ImageView) view.findViewById(R.id.img_photos);
            tv_title = (TextView)view.findViewById(R.id.tv_title);
            tv_url = (TextView)view.findViewById(R.id.tv_url);

        }
    }
}
