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
import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;

public class Custom_Spiner_Ctyxe extends ArrayAdapter {

    ArrayList<CtyXe> ctyXes;

    public Custom_Spiner_Ctyxe(@NonNull Context context, ArrayList<CtyXe> ctyXes) {


        super(context, 0, ctyXes);
        this.ctyXes = ctyXes;
    }

    @Override
    public int getCount() {
        return ctyXes.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spiner_ctyxe, parent, false);
        TextView textView = convertView.findViewById(R.id.tv_name_ctyxe);
        ImageView imageView = convertView.findViewById(R.id.icon_ctyxe);

        CtyXe ctyXe = ctyXes.get(position);

        textView.setText(ctyXe.getMaLoai());
        imageView.setImageResource(MainActivity.getImageId(convertView.getContext(), ctyXe.getImage()));

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spiner_ctyxe, parent, false);
        TextView textView = convertView.findViewById(R.id.tv_name_ctyxe);
        ImageView imageView = convertView.findViewById(R.id.icon_ctyxe);

        CtyXe ctyXe = ctyXes.get(position);

        textView.setText(ctyXe.getMaLoai());
        imageView.setImageResource(MainActivity.getImageId(convertView.getContext(), ctyXe.getImage()));

        return convertView;
    }


}
