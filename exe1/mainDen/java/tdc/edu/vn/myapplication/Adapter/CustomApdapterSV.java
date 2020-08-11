package tdc.edu.vn.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import tdc.edu.vn.myapplication.GiaoDien.ChiTietActivity;
import tdc.edu.vn.myapplication.Model.SinhVien;
import tdc.edu.vn.myapplication.R;

public class CustomApdapterSV extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<SinhVien> data;
    ArrayList<SinhVien> data_DS;

    public CustomApdapterSV(Context context, int resource, ArrayList<SinhVien> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.data_DS = new ArrayList<SinhVien>();
        this.data_DS.addAll(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    private static class Holder {
        ImageView imgHinh;
        ImageView imgDetail;
        TextView tvHoTen;
        TextView tvDiaChi;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder = null;
        if (view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(resource, null);
            holder.imgHinh = view.findViewById(R.id.imgHinh);
            holder.imgDetail = view.findViewById(R.id.imgDetail);
            holder.tvHoTen = view.findViewById(R.id.tvHoten);
            holder.tvDiaChi = view.findViewById(R.id.tvDiaChi);
            view.setTag(holder);
        } else
            holder = (Holder) view.getTag();

        final SinhVien sinhVien = data.get(position);

        holder.tvHoTen.setText(sinhVien.getTenSV());
        holder.tvDiaChi.setText(sinhVien.getDiaChi());
        holder.imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent((Activity) context, ChiTietActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("ma", sinhVien.getMaSV());
                intent.putExtras(bundle);
                ((Activity) context).startActivity(intent);


            }
        });


        return view;
    }

    //filter
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        data.clear();
        if (charText.length() == 0) {
            data.addAll(data_DS);
        } else {
            for (SinhVien model : data_DS) {
                if (model.getTenSV().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    data.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}
