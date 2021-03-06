package com.example.breakscape;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class EvidenceAdapter extends BaseAdapter {
    public static int[] evidences = {
            R.drawable.e1, R.drawable.e2, R.drawable.e3, R.drawable.e4
    };
    private Context mContext;

    public EvidenceAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return evidences.length;
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
        imageView.setImageResource(evidences[position]);
        return imageView;
    }
}