package tdc.edu.vn.quanly_dathang_xemay.ui.DonDatHang;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.Custom_ListView_DDH;
import tdc.edu.vn.quanly_dathang_xemay.Add_Edit_ddh;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBDonDatHang;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.DonDatHang;

public class SlideshowFragment extends Fragment {

    ListView listView;
    ArrayList<DonDatHang> donDatHangs = new ArrayList<>();
    View root;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_dondathang, container, false);
        setHasOptionsMenu(true);


        setControl(root);
        setEvent();

        return root;
    }

    private void autoLoad() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DBDonDatHang dbDonDatHang = new DBDonDatHang(root.getContext());
                donDatHangs = dbDonDatHang.get_DonDatHang();

                Custom_ListView_DDH custom_listView_ddh = new Custom_ListView_DDH(donDatHangs, getContext());
                listView.setAdapter(custom_listView_ddh);
                new Handler().postDelayed(this, 3000);
            }
        }, 3000);

    }

    private void setEvent() {
        autoLoad();
    }


    private void setControl(View root) {
        listView = root.findViewById(R.id.listview_DDH);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bar_them2:
                Intent intent = new Intent(getContext(), Add_Edit_ddh.class);
                intent.putExtra("check", false);
                startActivity(intent);
                break;
        }

        return true;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_add_ddh, menu);

    }
}
