package tdc.edu.vn.quanly_dathang_xemay.AdapterCustom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.EditCtyXe;
import tdc.edu.vn.quanly_dathang_xemay.MainActivity;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.Xe;

public class CustomPagerView extends PagerAdapter {
    ArrayList<Xe> xes;
    Context context;
    LayoutInflater layoutInflater;

    public CustomPagerView(ArrayList<Xe> xes, Context context) {
        this.xes = xes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return xes.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        final View view = layoutInflater.inflate(R.layout.item_xe, container, false);

        ImageView imageXe = view.findViewById(R.id.image_xe);
        TextView tvMaXe = view.findViewById(R.id.tvmaxe);
        TextView tvTenXe = view.findViewById(R.id.tvtenxe);
        TextView tvDungTich = view.findViewById(R.id.tvdungtich);
        TextView tvSoLuong = view.findViewById(R.id.tvsoluongxe);
        TextView tvMaLoai_ctyxe_xe = view.findViewById(R.id.tvmaloai_ctyxe_xe);

        Xe xe = xes.get(position);
//Co data thi show cai nay
        imageXe.setImageResource(MainActivity.getImageId(context, xe.getImage()));

        tvMaXe.setText(xe.getMaXe());
        tvTenXe.setText(xe.getTenXe());
        tvDungTich.setText(xe.getDungTich() + "cc");
        tvSoLuong.setText("Số Lượng: " + xe.getSoLuong());
        tvMaLoai_ctyxe_xe.setText(xe.getMaLoai());

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
