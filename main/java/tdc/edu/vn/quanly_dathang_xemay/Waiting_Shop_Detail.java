package tdc.edu.vn.quanly_dathang_xemay;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.Custom_item_waiting_shop_detail;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBController;

public class Waiting_Shop_Detail extends AppCompatActivity {

    ArrayList<ArrayList> data = new ArrayList<>();

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting__shop__detail);
        setControl();
        setEvent();
    }

    private void HienThidata() {
        DBController dbController = new DBController(getApplicationContext());
        data = dbController.getTempp();

        Custom_item_waiting_shop_detail custom_item_waiting_shop_detail = new Custom_item_waiting_shop_detail(data, getApplicationContext());
        lv.setAdapter(custom_item_waiting_shop_detail);
    }

    private void setEvent() {
        HienThidata();
    }


    private void setControl() {
        lv = findViewById(R.id.lv_waiting_shop);
    }
}
