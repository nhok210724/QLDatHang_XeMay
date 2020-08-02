package tdc.edu.vn.quanly_dathang_xemay.AdapterCustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.CustomSpiner.Custom_Spiner_Xe;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBChiTietDonDatHang;
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
    Spinner sprSoluong, sprDonGia;


    Button btnSua, btnXoa;

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
        sprSoluong = convertView.findViewById(R.id.sprSoLuongDH);
        sprDonGia = convertView.findViewById(R.id.sprDonGia);

        btnSua = convertView.findViewById(R.id.btn_Sua_ChiTiet);
        btnXoa = convertView.findViewById(R.id.btn_Xoa_ChiTiet);
        sprmaDH.setEnabled(false);
        ShowSpiner(convertView, position);


        return convertView;
    }

    private void ShowSpiner(View v, int position) {
        ArrayList<String> data_maDH = new DBDonDatHang(v.getContext()).get_MaDDH();

        ArrayAdapter arrayAdapter = new ArrayAdapter(v.getContext(), android.R.layout.simple_spinner_item, data_maDH);
        sprmaDH.setAdapter(arrayAdapter);

        final ArrayList<Xe> xes = new DBTenXe(v.getContext()).getDL();
        Custom_Spiner_Xe custom_spiner_xe = new Custom_Spiner_Xe(v.getContext(), xes);
        sprmaXe.setAdapter(custom_spiner_xe);

        final ChiTietDonDatHang chiTietDonDatHang = chiTietDonDatHangs.get(position);

        sprmaDH.setSelection(data_maDH.indexOf((String) chiTietDonDatHang.getMaDDH()));


        for (Xe xe : xes) {
            if (chiTietDonDatHang.getMaXe().equals(xe.getMaXe())) {
                sprmaXe.setSelection(xes.indexOf(xe));
                break;
            }
        }

        ArrayAdapter adapter = new ArrayAdapter(v.getContext(), android.R.layout.simple_spinner_item, Custom_listview_Shop.spr_soluong);
        sprSoluong.setAdapter(adapter);

        sprSoluong.setSelection(chiTietDonDatHang.getSoLuongDatHang() - 1);

        ArrayAdapter adapter1 = new ArrayAdapter(v.getContext(), android.R.layout.simple_spinner_item, Custom_listview_Shop.ints);
        sprDonGia.setAdapter(adapter1);

        sprDonGia.setSelection(Custom_listview_Shop.ints.indexOf((Integer) chiTietDonDatHang.getDonGia()));


        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBChiTietDonDatHang dbChiTietDonDatHang = new DBChiTietDonDatHang(context);
                dbChiTietDonDatHang.Sua(new ChiTietDonDatHang(sprmaDH.getSelectedItem().toString()
                        , xes.get(sprmaXe.getSelectedItemPosition()).getMaXe(),
                        (Integer) sprSoluong.getSelectedItem(),
                        (Integer) sprDonGia.getSelectedItem()));
                Custom_toast.makeText(context, v.getResources().getString(R.string.dialogSua), Custom_toast.LENGTH_LONG, Custom_toast.SUCCESS).show();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBChiTietDonDatHang dbChiTietDonDatHang = new DBChiTietDonDatHang(context);
                dbChiTietDonDatHang.Xoa(chiTietDonDatHang);

                Custom_toast.makeText(context, v.getResources().getString(R.string.dialogXoa), Custom_toast.LENGTH_LONG, Custom_toast.SUCCESS).show();
            }
        });
    }
}
