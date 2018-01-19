package com.ptit.pakandroid.kentran97.newfirebasestorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by admin on 1/20/2018.
 */

public class HinhAnhAdapter extends BaseAdapter {
    Context myContext;
    int myLayout;
    List<HinhAnh> arrayHinh;

    public HinhAnhAdapter(Context myContext, int myLayout, List<HinhAnh> arrayHinh) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.arrayHinh = arrayHinh;
    }

    @Override
    public int getCount() {
        return arrayHinh.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayHinh.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView imgHinh;
        TextView txtTen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = convertView;
        ViewHolder holder = new ViewHolder();
        if (rowView == null) {
            rowView = inflater.inflate(myLayout, null);
            holder.txtTen = rowView.findViewById(R.id.textViewTen);
            holder.imgHinh = rowView.findViewById(R.id.imageViewHinh);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        //gan gia tri
        holder.txtTen.setText(arrayHinh.get(position).ten);
        Picasso.with(myContext).load(arrayHinh.get(position).link).into(holder.imgHinh);

        return rowView;
    }
}
