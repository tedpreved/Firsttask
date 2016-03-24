package com.home.firsttask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;


public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mUrlImages;
    private View.OnClickListener mOnImageClickListener;

    public GalleryAdapter(Context mContext, List<String> mUrlImages, View.OnClickListener callback) {
        this.mContext = mContext;
        this.mUrlImages = mUrlImages;
        this.mOnImageClickListener = callback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycleview_gallery, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mOnImageClickListener != null) {
            holder.imgPhoto.setOnClickListener(mOnImageClickListener);
        }

        final String urlProductImage = mUrlImages.get(position);
        Glide.with(mContext)
                .load(urlProductImage)
                .centerCrop()
                .crossFade()
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return mUrlImages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPhoto;

        public ViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_gallery);
        }
    }
}