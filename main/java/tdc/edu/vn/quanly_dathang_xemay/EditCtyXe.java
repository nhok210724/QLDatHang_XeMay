package tdc.edu.vn.quanly_dathang_xemay;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Magnifier;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.CustomRecyclerView;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBCtyXe;
import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;

public class EditCtyXe extends AppCompatActivity {


    ImageView img_logoctyxe;
    EditText maLoai, tenLoai, xuatXu;
    Button btnTroVe, btnSua, btnDel;
    Spinner spnDoiAnh;

    final int IMAGE_PICK_CODE = 1000;
    final int PERMISSION_CODE = 1001;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_ctyxe);
        setControl();
        setEvent();
    }

    private CtyXe getdata() {
        CtyXe ctyXe = new CtyXe(maLoai.getText().toString(), tenLoai.getText().toString(),
                xuatXu.getText().toString(), spnDoiAnh.getSelectedItem().toString());
        return ctyXe;
    }

    private void setEvent() {


        Intent intent = getIntent();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this.getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, Ctyxe_new.data_img);
        spnDoiAnh.setAdapter(arrayAdapter);


        img_logoctyxe.setImageResource(MainActivity.getImageId(this.getApplicationContext(), intent.getStringExtra("key")));


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
                onBackPressed();
            }
        });


        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBCtyXe dbCtyXe = new DBCtyXe(getApplicationContext());
                dbCtyXe.Xoa(ctyXe1);
                onBackPressed();
            }
        });


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
        img_logoctyxe = findViewById(R.id.img_edit_ctyxe);
        maLoai = findViewById(R.id.etmaloai);
        tenLoai = findViewById(R.id.ettenloai);
        xuatXu = findViewById(R.id.etxuatxu);

        btnTroVe = findViewById(R.id.btnTroVe);
        btnSua = findViewById(R.id.btnSua_ctyxe);
        btnDel = findViewById(R.id.btndel_ctyxe);
        spnDoiAnh = findViewById(R.id.spinerDoi_img);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.resgiter_menu, menu);
        return true;
    }
}
