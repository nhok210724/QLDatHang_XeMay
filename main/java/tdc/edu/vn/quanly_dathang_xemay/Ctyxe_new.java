package tdc.edu.vn.quanly_dathang_xemay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBCtyXe;
import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;
import tdc.edu.vn.quanly_dathang_xemay.ui.CtyXe.HomeFragment;

public class Ctyxe_new extends AppCompatActivity {
    public static final String[] data_img = {"vinfast_logo", "mercedes_logo", "bmw_logo", "audi_logo", "honda_logo", "lamborghini_logo",};
    ImageView img_logoctyxe;
    EditText maLoai, tenLoai, xuatXu;
    Button btnTroVe, btnThem;
    Spinner spnDoiAnh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__ctyxe);
        setControl();
        setEvent();

    }

    private void setEvent() {

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, data_img);
        spnDoiAnh.setAdapter(arrayAdapter);


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBCtyXe dbCtyXe = new DBCtyXe(getApplicationContext());
                CtyXe ctyXe = getDL();
                dbCtyXe.Them(ctyXe);

                onBackPressed();

            }
        });

        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//        spnDoiAnh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                img_logoctyxe.setImageResource(MainActivity.getImageId(getApplicationContext(), spnDoiAnh.getSelectedItem().toString()));
//
//            }
//        });
    }


    private CtyXe getDL() {
        CtyXe ctyXe = new CtyXe(maLoai.getText().toString(), tenLoai.getText().toString()
                , xuatXu.getText().toString(), spnDoiAnh.getSelectedItem().toString());
        return ctyXe;
    }

    private void setControl() {
        img_logoctyxe = findViewById(R.id.img_ctyxe_new);
        maLoai = findViewById(R.id.etmaloai_new);
        tenLoai = findViewById(R.id.ettenloai_new);
        xuatXu = findViewById(R.id.etxuatxu_new);
        spnDoiAnh = findViewById(R.id.spinerDoi_img_new);
        btnTroVe = findViewById(R.id.btnTroVe_new);
        btnThem = findViewById(R.id.btnThem_new);
    }
}
