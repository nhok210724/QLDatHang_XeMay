package tdc.edu.vn.quanly_dathang_xemay.ui.ChiTiet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.Waiting_Shop_Detail;

public class ChiTietModel extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chi_tiet_don_dat_hang, container, false);
        setHasOptionsMenu(true);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {

    }


    private void setControl(View view) {

    }

    //Click detail để chấp nhận thêm or k chấp nhận
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bar_shop_waiting:
                Intent intent = new Intent(getContext(), Waiting_Shop_Detail.class);
                startActivity(intent);
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
