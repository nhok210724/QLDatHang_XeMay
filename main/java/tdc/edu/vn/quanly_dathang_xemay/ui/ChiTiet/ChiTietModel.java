package tdc.edu.vn.quanly_dathang_xemay.ui.ChiTiet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.Custom_listview_ChiTiet;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBChiTietDonDatHang;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.Waiting_Shop_Detail;
import tdc.edu.vn.quanly_dathang_xemay.model.ChiTietDonDatHang;

public class ChiTietModel extends Fragment {

    ListView listView;
    ArrayList<ChiTietDonDatHang> chiTietDonDatHangs = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chi_tiet_don_dat_hang, container, false);
        setHasOptionsMenu(true);
        setControl(view);
        setEvent();
        return view;
    }

    private void ShowData() {
        chiTietDonDatHangs = new DBChiTietDonDatHang(getContext()).get_ChiTietDonDatHang();
        Custom_listview_ChiTiet custom_listview_chiTiet = new Custom_listview_ChiTiet(chiTietDonDatHangs, getContext());
        listView.setAdapter(custom_listview_chiTiet);
    }

    private void setEvent() {
        ShowData();
    }


    private void setControl(View view) {
        listView = view.findViewById(R.id.lv_ChiTiet);
    }

    //Click detail để chấp nhận thêm or k chấp nhận
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bar_shop_waiting:
                Intent intent = new Intent(getContext(), Waiting_Shop_Detail.class);
                startActivity(intent);
                break;
            case R.id.bar_load:
                ShowData();
                Toast.makeText(getContext(), "Cập Nhật Danh Sách", Toast.LENGTH_LONG).show();
                break;
        }

        return true;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.detail_menu_shop, menu);

    }
}
