package tdc.edu.vn.quanly_dathang_xemay;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.Custom_toast;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBDonDatHang;
import tdc.edu.vn.quanly_dathang_xemay.model.DonDatHang;

public class Add_Edit_ddh extends AppCompatActivity {
    Button TroVe, btnThem, btnSua, btnXoa;

    EditText maHD, ngayLap;

    DatePickerDialog.OnDateSetListener onDateSetListener;

    Button btnDate;
    LinearLayout animation_linear;
    ArrayList<DonDatHang> donDatHangs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__edit_ddh);
        setControl();
        setEvent();
    }

    //get data from item Don Dat Hang to Edit Don Dat hang
    private void CheckData() {
        Intent intent = getIntent();
        if (intent.getExtras().getBoolean("check")) {
            btnThem.setEnabled(false);
            btnXoa.setEnabled(true);
            btnSua.setEnabled(true);
            donDatHangs = new DBDonDatHang(getApplicationContext()).get_DonDatHang();
            DonDatHang donDatHang = donDatHangs.get(intent.getExtras().getInt("posion"));
            setEditText(donDatHang);
        } else {
            btnThem.setEnabled(true);
            btnXoa.setEnabled(false);
            btnSua.setEnabled(false);
        }
    }

    private void setEditText(DonDatHang donDatHang) {
        maHD.setText(donDatHang.getMaDDH());
        ngayLap.setText(donDatHang.getNgayLap());
    }


    //get data in EditText
    private DonDatHang getDonDatHang() {
        return new DonDatHang(maHD.getText().toString(), ngayLap.getText().toString());
    }

    private void setEvent() {
//Check date khi click edit Don Dat Hang
        CheckData();


        //set animation
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        maHD.startAnimation(animation);
        ngayLap.startAnimation(animation);
        btnDate.startAnimation(animation);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        animation_linear.startAnimation(animation1);

        //set Click listener
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        onDateSetListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                datePickerDialog.show();
            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                month = month + 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                ngayLap.setText(date);
            }
        };


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!maHD.getText().toString().isEmpty() && !ngayLap.getText().toString().isEmpty()) {
                    DBDonDatHang dbDonDatHang = new DBDonDatHang(getApplicationContext());
                    DonDatHang donDatHang = getDonDatHang();
                    dbDonDatHang.Them(donDatHang);
                    Custom_toast.makeText(getApplicationContext(), getResources().getString(R.string.dialogThem), Custom_toast.LENGTH_LONG, Custom_toast.SUCCESS).show();
                    onBackPressed();
                } else {
                    Custom_toast.makeText(getApplicationContext(), getResources().getString(R.string.dialogNotThem), Custom_toast.LENGTH_LONG, Custom_toast.WARNING).show();
                }

            }
        });

        TroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!maHD.getText().toString().isEmpty() && !ngayLap.getText().toString().isEmpty()) {
                    DBDonDatHang dbDonDatHang = new DBDonDatHang(getApplicationContext());
                    DonDatHang donDatHang = getDonDatHang();
                    dbDonDatHang.Sua(donDatHang);
                    Custom_toast.makeText(getApplicationContext(), getResources().getString(R.string.dialogSua),
                            Custom_toast.LENGTH_LONG, Custom_toast.SUCCESS).show();
                    onBackPressed();
                } else {
                    Custom_toast.makeText(getApplicationContext(), getResources().getString(R.string.dialogNotSua),
                            Custom_toast.LENGTH_LONG, Custom_toast.WARNING).show();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!maHD.getText().toString().isEmpty() && !ngayLap.getText().toString().isEmpty()) {
                    DBDonDatHang dbDonDatHang = new DBDonDatHang(getApplicationContext());
                    DonDatHang donDatHang = getDonDatHang();
                    dbDonDatHang.Xoa(donDatHang);
                    Custom_toast.makeText(getApplicationContext(), getResources().getString(R.string.dialogXoa),
                            Custom_toast.LENGTH_LONG, Custom_toast.SUCCESS).show();
                    onBackPressed();
                } else {
                    Custom_toast.makeText(getApplicationContext(), getResources().getString(R.string.dialogNotXoa),
                            Custom_toast.LENGTH_LONG, Custom_toast.WARNING).show();
                }
            }
        });
    }


    private void setControl() {
        TroVe = findViewById(R.id.TroVe_them_DDH);
        btnThem = findViewById(R.id.them_DDH);
        btnSua = findViewById(R.id.Sua_them_DDH);
        btnXoa = findViewById(R.id.Xoa_them_DDH);

        maHD = findViewById(R.id.etMaHD);
        ngayLap = findViewById(R.id.etNgayLap);
        btnDate = findViewById(R.id.btnDate);

        animation_linear = findViewById(R.id.animation_linear);

    }
}
