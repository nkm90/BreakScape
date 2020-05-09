package com.example.breakscape;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class StaffAdapter extends BaseAdapter {
    public static int[] staff = {
            R.drawable.staff1, R.drawable.staff2, R.drawable.staff3, R.drawable.staff4
    };
    private Context mContext;

    public StaffAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return staff.length;
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
        imageView.setImageResource(staff[position]);
        return imageView;
    }
}