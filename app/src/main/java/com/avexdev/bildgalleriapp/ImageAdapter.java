package com.avexdev.bildgalleriapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private ArrayList<Images>arrayList;
    private LayoutInflater mInflater;

    public ImageAdapter(Context context, ArrayList arrayList){
        mInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ImageViewHolder holder, int position) {
        String currentImageString = arrayList.get(position).image;
        Bitmap mCurrentImage = BitMap.getBitmapFromString(currentImageString);
        String mCurrentDescription = arrayList.get(position).description;
        holder.imageView.setImageBitmap(mCurrentImage);
        holder.textViewDescription.setText(mCurrentDescription);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textViewDescription;
        final ImageAdapter mAdapter;

        public ImageViewHolder(@NonNull View itemView, ImageAdapter adapter) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewDescription = itemView.findViewById(R.id.textView);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            Intent intent = new Intent(v.getContext(), ImageActivity.class);
            intent.putExtra("Picture", arrayList.get(mPosition).image);
            intent.putExtra("Description", arrayList.get(mPosition).description);
            v.getContext().startActivity(intent);

        }
    }
}
