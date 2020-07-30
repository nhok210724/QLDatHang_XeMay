package tdc.edu.vn.quanly_dathang_xemay;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.Custom_img_Ctyxe;
import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.Custom_toast;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBCtyXe;
import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;

public class EditCtyXe extends AppCompatActivity {


    final int IMAGE_PICK_CODE = 1000;
    final int PERMISSION_CODE = 1001;
    ImageView img_logoctyxe;
    EditText maLoai, tenLoai, xuatXu;
    Button btnTroVe, btnSua, btnDel;
    ArrayList<String> name_img_ctyxe = new ArrayList<>();
    Custom_img_Ctyxe Adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_ctyxe);
        setControl();
        setEvent();
    }

    private void getImg() {
        for (String name : Ctyxe_new.data_img) {
            name_img_ctyxe.add(name);
        }
    }

    private void autoload() {
        getImg();

        Adapter = new Custom_img_Ctyxe(name_img_ctyxe, getApplicationContext());
        viewPager.setAdapter(Adapter);
    }


    private CtyXe getdata() {
        CtyXe ctyXe = new CtyXe(maLoai.getText().toString(), tenLoai.getText().toString(),
                xuatXu.getText().toString(), name_img_ctyxe.get(viewPager.getCurrentItem()));
        return ctyXe;
    }

    private void setEvent() {
        autoload();

        Intent intent = getIntent();
        viewPager.setCurrentItem(name_img_ctyxe.indexOf(intent.getStringExtra("key")));


        maLoai.setText(intent.getStringExtra("key1"));
        tenLoai.setText(intent.getStringExtra("key2"));
        xuatXu.setText(intent.getStringExtra("key3"));

        final CtyXe ctyXe1 = getdata();


        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBCtyXe dbCtyXe = new DBCtyXe(getApplicationContext());
                dbCtyXe.Sua(ctyXe1);
                Custom_toast.makeText(getApplicationContext(), "Sửa Thành Công", Custom_toast.LENGTH_LONG, Custom_toast.SUCCESS).show();
                onBackPressed();
            }
        });


        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBCtyXe dbCtyXe = new DBCtyXe(getApplicationContext());
                dbCtyXe.Xoa(ctyXe1);
                Custom_toast.makeText(getApplicationContext(), "Xoá Thành Công", Custom_toast.LENGTH_LONG, Custom_toast.SUCCESS).show();
                onBackPressed();
            }
        });


    /*
     //how to get img from garry
     img_logoctyxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_DENIED) {
                        String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permission, PERMISSION_CODE);
                    } else {
                        pickImageFromGalley();
                    }
                } else {
                    pickImageFromGalley();
                }
            }
        });
        */
    }


    private void pickImageFromGalley() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {

            // Uri selectedImage = Uri.parse("/media/external/images/media/10");
            //     img_logoctyxe.setImageURI(selectedImage);


            // img_logoctyxe.setImageURI(data.getData());
            //  img_logoctyxe.setImageResource(MainActivity.getImageId(this, data.getData().toString()));

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    pickImageFromGalley();
                else
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void setControl() {
        viewPager = findViewById(R.id.pager_img);
        maLoai = findViewById(R.id.etmaloai);
        tenLoai = findViewById(R.id.ettenloai);
        xuatXu = findViewById(R.id.etxuatxu);

        btnTroVe = findViewById(R.id.btnTroVe);
        btnSua = findViewById(R.id.btnSua_ctyxe);
        btnDel = findViewById(R.id.btndel_ctyxe);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.resgiter_menu, menu);
        return true;
    }
}
