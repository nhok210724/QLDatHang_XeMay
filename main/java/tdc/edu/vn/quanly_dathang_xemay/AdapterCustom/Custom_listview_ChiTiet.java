package tdc.edu.vn.quanly_dathang_xemay.AdapterCustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.CustomSpiner.Custom_Spiner_Xe;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBDonDatHang;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBTenXe;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.ChiTietDonDatHang;
import tdc.edu.vn.quanly_dathang_xemay.model.Xe;

public class Custom_listview_ChiTiet extends BaseAdapter {
    ArrayList<ChiTietDonDatHang> chiTietDonDatHangs;
    Context context;

    Spinner sprmaDH;
    Spinner sprmaXe;
    TextView tvSoluong, tvDonGia;

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

        sprmaDH = convertView.findViewById(R.id.spr_ct_maHD);
        sprmaXe = convertView.findViewById(R.id.spr_ct_maXe);
        tvSoluong = convertView.findViewById(R.id.tvSoLuongDH);
        tvDonGia = convertView.findViewById(R.id.tvDonGia);

        ShowSpiner(convertView, position);


        return convertView;
    }

    private void ShowSpiner(View v, int position) {
        ArrayList<String> data_maDH = new DBDonDatHang(v.getContext()).get_MaDDH();

        ArrayAdapter arrayAdapter = new ArrayAdapter(v.getContext(), android.R.layout.simple_spinner_item, data_maDH);
        sprmaDH.setAdapter(arrayAdapter);

        ArrayList<Xe> xes = new DBTenXe(v.getContext()).getDL();
        Custom_Spiner_Xe custom_spiner_xe = new Custom_Spiner_Xe(v.getContext(), xes);
        sprmaXe.setAdapter(custom_spiner_xe);

        ChiTietDonDatHang chiTietDonDatHang = chiTietDonDatHangs.get(position);

        sprmaDH.setSelection(data_maDH.indexOf((String) chiTietDonDatHang.getMaDDH()));


        for (Xe xe : xes) {
            if (chiTietDonDatHang.getMaXe().equals(xe.getMaXe())) {
                sprmaXe.setSelection(xes.indexOf(xe));
                break;
            }
        }

        tvSoluong.setText(chiTietDonDatHang.getSoLuongDatHang() + "");
        tvDonGia.setText(chiTietDonDatHang.getDonGia() + "");
    }
}
