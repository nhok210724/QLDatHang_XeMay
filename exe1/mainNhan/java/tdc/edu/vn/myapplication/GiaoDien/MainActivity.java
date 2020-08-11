package tdc.edu.vn.myapplication.GiaoDien;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.Locale;

import tdc.edu.vn.myapplication.Adapter.CustomApdapterSV;
import tdc.edu.vn.myapplication.DataBase.DBSinhVien;
import tdc.edu.vn.myapplication.Model.SinhVien;
import tdc.edu.vn.myapplication.R;

public class MainActivity extends AppCompatActivity {
    Button  btnThem, btnXoa, btnSua, btnXoaTrang, btnThoat, btnVN, btnEN;
    EditText txtMaSV, txtHoTen, txtDiaChi;
    ListView lvDanhSachSV;
    boolean ngonngu=true;

    CustomApdapterSV apdapter ;
    ArrayList<SinhVien> data_SV = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setConTrol();
        setEvent();
    }

    private void setEvent() {

        HienThiDL();


        btnVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyenNgonNgu("vn");

            }
        });
        btnEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyenNgonNgu("en");
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ThemDL();
               SinhVien sinhVien = getSinhVien();
               HienThiDL();

            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaDL();
                SinhVien sinhVien = getSinhVien();
                HienThiDL();


            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuaDL();
                HienThiDL();
            }
        });
        btnXoaTrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaTrang();
                HienThiDL();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thoat();
            }
        });




    }

    private  void HienThiDL()
    {
        DBSinhVien dbSinhVien = new DBSinhVien(this);
        data_SV = dbSinhVien.LayDL();
        apdapter = new CustomApdapterSV(this,R.layout.listview_item,data_SV);
        lvDanhSachSV.setAdapter(apdapter);
    }

    private void Thoat(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Thông Báo !!!");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Bạn Muốn Thoát ?");
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void XoaTrang()
    {
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtDiaChi.setText("");

    }
    private void XoaDL()
    {
        DBSinhVien dbSinhVien = new DBSinhVien(getApplicationContext());
        SinhVien sinhvien = new SinhVien();
        sinhvien.setMaSV(txtMaSV.getText().toString());
        sinhvien.setTenSV(txtHoTen.getText().toString());
        sinhvien.setDiaChi(txtDiaChi.getText().toString());

        dbSinhVien.Xoa(sinhvien);
    }
    private  void ThemDL()
    {
        DBSinhVien dbSinhVien = new DBSinhVien(this);

        SinhVien sinhVien = new SinhVien();
        sinhVien.setMaSV(txtMaSV.getText().toString());
        sinhVien.setTenSV(txtHoTen.getText().toString());
        sinhVien.setDiaChi(txtDiaChi.getText().toString());
        dbSinhVien.Them(sinhVien);


    }
    public void chuyenNgonNgu(String language){
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        Intent itent = new Intent(MainActivity.this,MainActivity.class);
        startActivity(itent);
    }
    private void SuaDL()
    {
        DBSinhVien dbSinhVien = new DBSinhVien(getApplicationContext());
        SinhVien sinhvien = new SinhVien();
        sinhvien.setMaSV(txtMaSV.getText().toString());
        sinhvien.setTenSV(txtHoTen.getText().toString());
        sinhvien.setDiaChi(txtDiaChi.getText().toString());

        dbSinhVien.Sua(sinhvien);
    }

    private SinhVien getSinhVien()
    {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setMaSV(txtMaSV.getText().toString());
        sinhVien.setTenSV(txtHoTen.getText().toString());
        sinhVien.setDiaChi(txtDiaChi.getText().toString());


        return sinhVien;

    }
    private void setConTrol() {
        btnEN = findViewById(R.id.btnEN);
        btnVN = findViewById(R.id.btnVN);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        btnXoaTrang = findViewById(R.id.btnXoaTrang);
        txtMaSV = findViewById(R.id.txtMa);
        txtHoTen = findViewById(R.id.txtHoTen);
        txtDiaChi = findViewById(R.id.txtDiaChi);
        lvDanhSachSV = findViewById(R.id.lvDanhSach);



    }
}
