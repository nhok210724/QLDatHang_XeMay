package tdc.edu.vn.quanly_dathang_xemay;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.CustomItemXe_Img;
import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.Custom_toast;
import tdc.edu.vn.quanly_dathang_xemay.CustomSpiner.Custom_Spiner_Ctyxe;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBCtyXe;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBTenXe;
import tdc.edu.vn.quanly_dathang_xemay.Unknow.Linked_Image;
import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;
import tdc.edu.vn.quanly_dathang_xemay.model.Xe;

public class Add_Edit_Xe extends AppCompatActivity {

    ViewPager viewPager;

    Spinner sprmaLoai;
    Button TroVe, btnThem, btnSua, btnXoa;

    EditText maXe, tenXe, dungTich, soLuong;

    ArrayList<String> maloais = new ArrayList<>();
    ArrayList<String> tenImgs = new ArrayList<>();

    ArrayList<CtyXe> ctyXes = new ArrayList<>();
    String[] tenImg_theoMaloai;
    int index = 0;
    boolean checkedit = false;

    int posion_img = -1;

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

    //Set erro EditText:
    private void checkEditText() {
        if (maXe.getText().toString().isEmpty())
            maXe.setError(getResources().getString(R.string.erroEditText));
        if (tenXe.getText().toString().isEmpty())
            tenXe.setError(getResources().getString(R.string.erroEditText));
        if (dungTich.getText().toString().isEmpty())
            dungTich.setError(getResources().getString(R.string.erroEditText));
        if (soLuong.getText().toString().isEmpty())
            soLuong.setError(getResources().getString(R.string.erroEditText));
    }


    //Get data in Intent
    private void checkIntent() {


        Intent intent = getIntent();
        checkedit = intent.getExtras().getBoolean("check");
        if (checkedit) {

            btnThem.setEnabled(false);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);

            DBTenXe dbTenXe = new DBTenXe(getApplicationContext());
            ArrayList<Xe> xes = dbTenXe.getDL();
            Xe xe = xes.get(intent.getExtras().getInt("vitri"));

            tenImgs.clear();

            sprmaLoai.setSelection(maloais.indexOf(xe.getMaLoai()));
            loadspr_img();

            //sprmaLoai.setSelection(0);

            posion_img = tenImgs.indexOf(xe.getImage());
            viewPager.setCurrentItem(posion_img);


            maXe.setText(xe.getMaXe());
            tenXe.setText(xe.getTenXe());
            dungTich.setText(xe.getDungTich() + "");
            soLuong.setText(xe.getSoLuong() + "");
            // viewPager.setCurrentItem(tenImgs.indexOf(intent.getStringExtra("img")));


            //maXe.setText(posion_img + "");


        } else {
            btnThem.setEnabled(true);
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
        }
    }

    //remove data in database
    private void remove_data() {
        String ten = tenImgs.get(viewPager.getCurrentItem());
        if (!maXe.getText().toString().isEmpty() && !tenXe.getText().toString().isEmpty()
                && !dungTich.getText().toString().isEmpty() && !soLuong.getText().toString().isEmpty()) {
            Xe xe = new Xe(maXe.getText().toString(), tenXe.getText().toString()
                    , Integer.parseInt(dungTich.getText().toString())
                    , Integer.parseInt(soLuong.getText().toString())
                    , ten, ctyXes.get(sprmaLoai.getSelectedItemPosition()).getMaLoai());
            DBTenXe dbTenXe = new DBTenXe(getApplicationContext());
            dbTenXe.Xoa(xe);

            Custom_toast.makeText(getApplicationContext(), getResources().getString(R.string.dialogXoa), Custom_toast.LENGTH_LONG, Custom_toast.SUCCESS).show();
            // Toast.makeText(getApplicationContext(), "Sửa Thành Công", Toast.LENGTH_LONG).show();
        } else {
            checkEditText();
            Custom_toast.makeText(getApplicationContext(), getResources().getString(R.string.dialogNotXoa), Custom_toast.LENGTH_LONG, Custom_toast.WARNING).show();
            //Toast.makeText(getApplicationContext(), "Sửa Không Thành Công", Toast.LENGTH_LONG).show();
        }
    }

    //Update data send to data:
    private void fixdata_sendtoData() {
        String ten = tenImgs.get(viewPager.getCurrentItem());
        if (!maXe.getText().toString().isEmpty() && !tenXe.getText().toString().isEmpty()
                && !dungTich.getText().toString().isEmpty() && !soLuong.getText().toString().isEmpty()) {
            Xe xe = new Xe(maXe.getText().toString(), tenXe.getText().toString()
                    , Integer.parseInt(dungTich.getText().toString())
                    , Integer.parseInt(soLuong.getText().toString())
                    , ten, ctyXes.get(sprmaLoai.getSelectedItemPosition()).getMaLoai());
            DBTenXe dbTenXe = new DBTenXe(getApplicationContext());
            dbTenXe.Sua(xe);

            Custom_toast.makeText(getApplicationContext(), getResources().getString(R.string.dialogSua), Custom_toast.LENGTH_LONG, Custom_toast.SUCCESS).show();
            // Toast.makeText(getApplicationContext(), "Sửa Thành Công", Toast.LENGTH_LONG).show();
        } else {
            checkEditText();
            Custom_toast.makeText(getApplicationContext(), getResources().getString(R.string.dialogNotSua), Custom_toast.LENGTH_LONG, Custom_toast.WARNING).show();
            //Toast.makeText(getApplicationContext(), "Sửa Không Thành Công", Toast.LENGTH_LONG).show();
        }

    }


    //Get name Img And add to database
    public void addToDatadabase() {
        String ten = tenImgs.get(viewPager.getCurrentItem());
        if (!maXe.getText().toString().isEmpty() && !tenXe.getText().toString().isEmpty()
                && !dungTich.getText().toString().isEmpty() && !soLuong.getText().toString().isEmpty()) {
            Xe xe = new Xe(maXe.getText().toString(), tenXe.getText().toString()
                    , Integer.parseInt(dungTich.getText().toString())
                    , Integer.parseInt(soLuong.getText().toString())
                    , ten, ctyXes.get(sprmaLoai.getSelectedItemPosition()).getMaLoai());
            DBTenXe dbTenXe = new DBTenXe(getApplicationContext());
            dbTenXe.Them(xe);

            Custom_toast.makeText(getApplicationContext(), getResources().getString(R.string.dialogThem), Custom_toast.LENGTH_LONG, Custom_toast.SUCCESS).show();
            //Toast.makeText(getApplicationContext(), "Thêm Thành Công", Toast.LENGTH_LONG).show();
        } else {
            checkEditText();
            Custom_toast.makeText(getApplicationContext(), getResources().getString(R.string.dialogNotThem),
                    Custom_toast.LENGTH_LONG, Custom_toast.WARNING).show();
            //Toast.makeText(getApplicationContext(), "Thêm Không Thành Công", Toast.LENGTH_LONG).show();
        }


    }
//Sua data setup spiner


    //Load Spiner

    private void sprLoad() {
        DBCtyXe dbCtyXe = new DBCtyXe(getApplicationContext());
        maloais = dbCtyXe.getMaloai();
        ctyXes = dbCtyXe.get_ctyXes();

        Custom_Spiner_Ctyxe arrayAdapter = new Custom_Spiner_Ctyxe(getApplicationContext(), ctyXes);

        sprmaLoai.setAdapter(arrayAdapter);


    }

    //load Img
    private void loadspr_img() {
        for (CtyXe ctyXe : ctyXes) {
            if (ctyXe.equals((CtyXe) sprmaLoai.getSelectedItem())) {
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


        loadspr_img();
        //Fix Set vitri viewpager
        checkIntent();


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
                if (!checkedit) {
                    tenImgs.clear();
                    loadspr_img();

                } else {
                    checkedit = false;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToDatadabase();
                onBackPressed();

            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fixdata_sendtoData();
                onBackPressed();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove_data();
                onBackPressed();
            }
        });

        maXe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();
                if (str.length() > 0 && str.contains(" ")) {
                    maXe.setError(getResources().getString(R.string.erroMa));

                }
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
        btnSua = findViewById(R.id.Sua_xe);
        btnXoa = findViewById(R.id.Xoa_xe);
    }


}
