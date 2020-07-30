package tdc.edu.vn.quanly_dathang_xemay;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //New Control

    Button btnsubmit, btnexit, btnMusic, btnShop;

    Animation animation;
    ImageView img;
    Handler handler = new Handler();

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();

        //Event
        setevent();


    }

    private void autoAnimation() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                img.setVisibility(View.VISIBLE);
                img.startAnimation(animation);
                handler.postDelayed(this, 3000);
            }
        }, 3000);

    }

    private void setevent() {
        autoAnimation();

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, menu_admin.class);
                startActivity(intent);
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Bạn Có Muốn Thoát?").setTitle("Thông Báo");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();


            }
        });

        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Music.class);
                startActivity(intent);
            }
        });
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DatHangShop.class);
                startActivity(intent);
            }
        });
    }

    //Set Control
    private void setControl() {

        btnsubmit = findViewById(R.id.btnSubmit);
        btnexit = findViewById(R.id.btnExit);
        btnMusic = findViewById(R.id.btnMusic);
        btnShop = findViewById(R.id.btnDatHang);


        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slider_show);
        img = findViewById(R.id.animation_hello);
    }


}
