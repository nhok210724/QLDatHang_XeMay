package tdc.edu.vn.quanly_dathang_xemay;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.Custom_listview_Shop;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBTenXe;
import tdc.edu.vn.quanly_dathang_xemay.model.Xe;

public class DatHangShop extends AppCompatActivity {
    ListView lvshop;
    ArrayList<Xe> xes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_hang_shop);
        setControl();
        setEvent();
    }

    private void HienThiData() {
        xes = new DBTenXe(getApplicationContext()).getDL();
        Custom_listview_Shop custom_listview_shop = new Custom_listview_Shop(xes, getApplicationContext());
        lvshop.setAdapter(custom_listview_shop);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        lvshop.startAnimation(animation);
    }

    private void setEvent() {
        HienThiData();
    }


    private void setControl() {
        lvshop = findViewById(R.id.lv_shop);
    }


}
