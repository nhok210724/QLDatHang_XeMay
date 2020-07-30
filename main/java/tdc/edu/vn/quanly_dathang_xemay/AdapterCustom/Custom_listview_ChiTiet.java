package tdc.edu.vn.quanly_dathang_xemay.AdapterCustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.ChiTietDonDatHang;

public class Custom_listview_ChiTiet extends BaseAdapter {
    ArrayList<ChiTietDonDatHang> chiTietDonDatHangs;
    Context context;

    public Custom_listview_ChiTiet(ArrayList<ChiTietDonDatHang> chiTietDonDatHangs, Context context) {
        this.chiTietDonDatHangs = chiTietDonDatHangs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return chiTietDonDatHangs.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_chi_tiet, parent, false);
        return convertView;
    }
}
