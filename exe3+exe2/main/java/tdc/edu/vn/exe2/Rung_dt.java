package tdc.edu.vn.exe2;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Rung_dt extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    Sensor sensor;
    ImageView imageView;
    TextView So;
    int i = 1;

    int[] ints = {R.drawable.sx_1, R.drawable.sx_2, R.drawable.sx_3, R.drawable.sx_4, R.drawable.sx_5, R.drawable.sx_6};
    Random rd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rung_dt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();

    }

    private void setEvent() {


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);


    }

    public void getVecTor_vatdoitext(SensorEvent event) {

        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        float vector = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        if (vector >= 2) {

            imageView.setImageResource(ints[i]);
        }

        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void setControl() {
        imageView = findViewById(R.id.imghinh);
        So = findViewById(R.id.so);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {


        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        float tgDau = SensorManager.GRAVITY_EARTH;
        float tgSau = SensorManager.GRAVITY_EARTH;
        float shake = 0.00f;
        tgDau = (float) (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        float deta = tgDau - tgSau;
        shake = shake * 0.9f + deta;
        i = rd.nextInt(5);
        if (shake > 12) {
            imageView.setImageResource(ints[i]);
            So.setText("Xí Ngầu Số: " + (i + 1));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
