package tdc.edu.vn.myapplication.GiaoDien;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;



import java.util.ArrayList;

import tdc.edu.vn.myapplication.Adapter.CustomApdapterSV;
import tdc.edu.vn.myapplication.DataBase.DBSinhVien;
import tdc.edu.vn.myapplication.Model.SinhVien;
import tdc.edu.vn.myapplication.R;

public class ChiTietActivity extends AppCompatActivity {
    EditText txtMaSV, txtHoTen, txtDiaChi;
    ArrayList<SinhVien> data_SV = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        setConTrol();
        setEvent();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void setEvent() {
        String ma= getIntent().getExtras().getString("ma");
        DBSinhVien dbSinhVien = new DBSinhVien(this);
        data_SV = dbSinhVien.LayDL();
        txtMaSV.setText(data_SV.get(0).getMaSV());
        txtHoTen.setText(data_SV.get(0).getTenSV());
        txtDiaChi.setText(data_SV.get(0).getDiaChi());

    }



    private void setConTrol() {
        txtMaSV = findViewById(R.id.txtMa);
        txtHoTen = findViewById(R.id.txtHoTen);
        txtDiaChi = findViewById(R.id.txtDiaChi);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
