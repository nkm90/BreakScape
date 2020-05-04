package com.example.breakscape;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public ImageAdapter(Context c) {
        mContext = c;
    }
    public int getCount() {
        return images.length;
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }
    // create a new ImageView for each item referenced by the Adapter
    public ImageView getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setImageResource(images[position]);
        return imageView;
    }
    // Add all our images to arraylist
    public Integer[] images = {
            R.drawable.g1, R.drawable.s1, R.drawable.g2, R.drawable.g3,
            R.drawable.s2, R.drawable.g4, R.drawable.g5, R.drawable.g6,
            R.drawable.g7, R.drawable.g8, R.drawable.g9, R.drawable.s3,
            R.drawable.g10, R.drawable.g11, R.drawable.s4, R.drawable.g12
    };
}
