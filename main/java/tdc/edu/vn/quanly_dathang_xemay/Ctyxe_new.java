package tdc.edu.vn.quanly_dathang_xemay;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.Custom_img_Ctyxe;
import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.Custom_toast;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBCtyXe;
import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;


public class Ctyxe_new extends AppCompatActivity {
    public static final String[] data_img = {"logo_honda", "logo_kawasaki", "logo_suzuki", "logo_sym", "logo_yamaha"};
    ArrayList<String> name_img_ctyxe = new ArrayList<>();
    ViewPager viewPager;
    EditText maLoai, tenLoai, xuatXu;
    Button btnTroVe, btnThem;
    Custom_img_Ctyxe Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__ctyxe);
        setControl();
        setEvent();

    }

    private void setEvent() {
        autoload();


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!maLoai.getText().toString().isEmpty() && !tenLoai.getText().toString().isEmpty()
                        && !xuatXu.getText().toString().isEmpty()) {
                    DBCtyXe dbCtyXe = new DBCtyXe(getApplicationContext());
                    CtyXe ctyXe = getDL();
                    dbCtyXe.Them(ctyXe);
                    Custom_toast.makeText(getApplicationContext(), "Thêm Thành Công", Custom_toast.LENGTH_LONG, Custom_toast.SUCCESS).show();
                    //  Toast.makeText(getApplicationContext(), "Thêm Thành Công", Toast.LENGTH_LONG).show();
                    onBackPressed();
                } else {
                    Custom_toast.makeText(getApplicationContext(), "Thêm Không Thành Công", Custom_toast.LENGTH_LONG, Custom_toast.ERROR).show();
                    //  Toast.makeText(getApplicationContext(), "Thêm Không Thành Công", Toast.LENGTH_LONG).show();
                }


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

    //Get all img name in String[] data_img = {"vinfast_logo", "mercedes_logo", "bmw_logo", "audi_logo", "honda_logo", "lamborghini_logo"};
    private void getImg() {
        for (String name : data_img) {
            name_img_ctyxe.add(name);
        }
    }

    private void autoload() {
        getImg();

        Adapter = new Custom_img_Ctyxe(name_img_ctyxe, getApplicationContext());
        viewPager.setAdapter(Adapter);
    }

    private CtyXe getDL() {
        CtyXe ctyXe = new CtyXe(maLoai.getText().toString(), tenLoai.getText().toString()
                , xuatXu.getText().toString(), name_img_ctyxe.get(viewPager.getCurrentItem()));
        return ctyXe;
    }

    private void setControl() {
        viewPager = findViewById(R.id.viewpager_img_ctyxe);
        maLoai = findViewById(R.id.etmaloai_new);
        tenLoai = findViewById(R.id.ettenloai_new);
        xuatXu = findViewById(R.id.etxuatxu_new);

        btnTroVe = findViewById(R.id.btnTroVe_new);
        btnThem = findViewById(R.id.btnThem_new);
    }
}
