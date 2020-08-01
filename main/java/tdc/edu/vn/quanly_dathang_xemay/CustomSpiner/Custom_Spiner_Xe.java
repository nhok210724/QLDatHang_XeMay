package tdc.edu.vn.quanly_dathang_xemay.CustomSpiner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.MainActivity;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.Xe;

public class Custom_Spiner_Xe extends ArrayAdapter {
    ArrayList<Xe> xes;

    public Custom_Spiner_Xe(@NonNull Context context, ArrayList<Xe> xes) {
        super(context, 0, xes);
        this.xes = xes;
    }

    @Override
    public int getCount() {
        return xes.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spiner_xe, parent, false);

        ImageView imageView = convertView.findViewById(R.id.icon_xe);
        TextView textView = convertView.findViewById(R.id.tv_xe);

        Xe xe = xes.get(position);

        imageView.setImageResource(MainActivity.getImageId(convertView.getContext(), xe.getImage()));
        textView.setText(xe.getMaXe());


        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spiner_xe, parent, false);


        ImageView imageView = convertView.findViewById(R.id.icon_xe);
        TextView textView = convertView.findViewById(R.id.tv_xe);

        Xe xe = xes.get(position);

        imageView.setImageResource(MainActivity.getImageId(convertView.getContext(), xe.getImage()));
        textView.setText(xe.getMaXe());
        return convertView;
    }
}
