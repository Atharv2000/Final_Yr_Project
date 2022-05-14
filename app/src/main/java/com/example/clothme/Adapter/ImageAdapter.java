package com.example.clothme.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothme.Models.ImageModel;
import com.example.clothme.R;
import com.example.clothme.View_Wardrobe;

import java.util.ArrayList;

public class ImageAdapter extends  RecyclerView.Adapter<ImageAdapter.ViewHolder>{
    ArrayList<ImageModel> list;
    Context context;
    ImageView imageView;
    TextView textView;
    public ImageAdapter(View v){

    }

    public ImageAdapter(ArrayList<ImageModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_image,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ImageModel im=list.get(position);
        holder.imageView.setImageBitmap(im.getBitmap());
        holder.textView.setText(im.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(v.getContext(), View_Wardrobe.class);
                i.putExtra("clothId",im.getId());
//                Log.v("AAA1",im.getId());
                i.putExtra("position",holder.getAdapterPosition());
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.id_im);
            textView=itemView.findViewById(R.id.id_tv);
        }
    }
}
