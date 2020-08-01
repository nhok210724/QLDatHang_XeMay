package tdc.edu.vn.quanly_dathang_xemay;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Animation_Car extends AppCompatActivity {
    AnimationDrawable Car_animation;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation__car);
        setControl();
        setEvent();
    }

    private void setEvent() {
        imageView.setBackgroundResource(R.drawable.car_animation);
        Car_animation = (AnimationDrawable) imageView.getBackground();
        Car_animation.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(Animation_Car.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    private void setControl() {
        imageView = findViewById(R.id.animation_car);
    }


}
