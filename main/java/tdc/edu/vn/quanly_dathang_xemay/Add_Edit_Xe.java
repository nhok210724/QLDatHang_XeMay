package tdc.edu.vn.quanly_dathang_xemay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.CustomItemXe_Img;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBCtyXe;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBTenXe;
import tdc.edu.vn.quanly_dathang_xemay.Unknow.Linked_Image;
import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;
import tdc.edu.vn.quanly_dathang_xemay.model.Xe;

public class Add_Edit_Xe extends AppCompatActivity {
    Handler handler;
    ViewPager viewPager;

    Spinner sprmaLoai;
    Button TroVe, btnThem;

    EditText maXe, tenXe, dungTich, soLuong;

    ArrayList<String> maloais = new ArrayList<>();
    ArrayList<String> tenImgs = new ArrayList<>();

    ArrayList<CtyXe> ctyXes = new ArrayList<>();
    String[] tenImg_theoMaloai;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__edit__xe);
        setControl();
        setEvent();
    }
//auto load List img xe
    /*
    public void autoLoad() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    loadspr_img();
                } catch (Exception e) {

                    e.printStackTrace();
                }
                handler.postDelayed(this, 2000);
            }
        }, 2000);
    }*/

    //Get name Img And add to database
    public void addToDatadabase() {
        String ten = tenImgs.get(viewPager.getCurrentItem());
        if (maXe.getText().toString().isEmpty() && tenXe.getText().toString().isEmpty()
                && dungTich.getText().toString().isEmpty() && soLuong.getText().toString().isEmpty()){
            Xe xe = new Xe(maXe.getText().toString(), tenXe.getText().toString()
                    , Integer.parseInt(dungTich.getText().toString())
                    , Integer.parseInt(soLuong.getText().toString())
                    , ten, sprmaLoai.getSelectedItem().toString());
            DBTenXe dbTenXe = new DBTenXe(getApplicationContext());
            dbTenXe.Them(xe);
            Toast.makeText(getApplicationContext(),"Thêm Thành Công",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"Thêm Không Thành Công",Toast.LENGTH_LONG).show();
        }


    }


    //Load Spiner

    private void sprLoad() {
        DBCtyXe dbCtyXe = new DBCtyXe(getApplicationContext());
        maloais = dbCtyXe.getMaloai();
        ctyXes = dbCtyXe.get_ctyXes();

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, maloais);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprmaLoai.setAdapter(arrayAdapter);


    }

    //load Img
    private void loadspr_img() {
        for (CtyXe ctyXe : ctyXes) {
            if (sprmaLoai.getSelectedItem().toString().equals(ctyXe.getMaLoai())) {
                sprImg(ctyXe.getImage());
                break;
            }
        }
    }

    //Get Img Theo Hang Xe
    private void sprImg(String tenImg) {
        tenImg_theoMaloai = new Linked_Image().check_Img(tenImg);

        if (tenImg_theoMaloai != null) {
            for (String ten : tenImg_theoMaloai) {
                tenImgs.add(ten);
            }
        }

        CustomItemXe_Img arrayAdapter = new CustomItemXe_Img(tenImgs, getApplicationContext());
        viewPager.setAdapter(arrayAdapter);
    }

    //Set Event
    private void setEvent() {
        sprLoad();


        TroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        sprmaLoai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // handler.removeCallbacksAndMessages(null);
                tenImgs.clear();
                loadspr_img();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                maXe.setText(viewPager.getCurrentItem() + "");
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                index = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //Set Control
    private void setControl() {


        maXe = findViewById(R.id.et_add_edit_MaXe);
        tenXe = findViewById(R.id.et_add_edit_TenXe);
        dungTich = findViewById(R.id.et_add_edit_DungTich);
        soLuong = findViewById(R.id.et_add_edit_SoLuong);

        TroVe = findViewById(R.id.TroVe_xe);
        sprmaLoai = findViewById(R.id.sprMaLoai_add_edit_xe);

        viewPager = findViewById(R.id.viewpager_img);

        btnThem = findViewById(R.id.them_xe);

    }


}
