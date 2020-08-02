package tdc.edu.vn.quanly_dathang_xemay;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HienThidata();
                new Handler().postDelayed(this, 3000);
            }
        }, 3000);


    }


    private void setControl() {
        lv = findViewById(R.id.lv_waiting_shop);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bar_back:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar_back, menu);
        return super.onCreateOptionsMenu(menu);

    }


}
