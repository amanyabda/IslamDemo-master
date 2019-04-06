package com.hassan.islamicdemo.Activiteis;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hassan.islamicdemo.R;
import java.io.File;
import java.util.ArrayList;


public class ImagesAdapter  extends  RecyclerView.Adapter<ImagesAdapter.MyViewHolder>{
 private LayoutInflater inflater;
    private ArrayList<Images> imageModelArrayList;
    private Context context;

    public ImagesAdapter(Context context,ArrayList<Images> imageModelArrayList) {
        this.inflater = LayoutInflater.from(context);
        this.imageModelArrayList = imageModelArrayList; }
    @NonNull
    @Override
    public ImagesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_image, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder; }
    @Override
    public void onBindViewHolder(@NonNull ImagesAdapter.MyViewHolder holder, int position) {
        holder.image.setImageResource(imageModelArrayList.get(position).getImage());
        holder.save.setText(imageModelArrayList.get(position).getSave());
        holder.share.setText(imageModelArrayList.get(position).getShare());
        holder.well.setText(imageModelArrayList.get(position).getWall()); }
    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView save,share,well;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            save = (TextView) itemView.findViewById(R.id.save);
            share = (TextView) itemView.findViewById(R.id.share);
            well = (TextView) itemView.findViewById(R.id.set_wallpaper);
            image = (ImageView) itemView.findViewById(R.id.a2);

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Toast.makeText(context, "لا يوجد تطبيق واتس اب", Toast.LENGTH_SHORT).show();
                    }

            });
            

        }

    }


    }
