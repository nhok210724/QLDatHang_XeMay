package tdc.edu.vn.exe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button sensorView, sensorBuzz, customview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        sensorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), view_sensor.class);
                startActivity(intent);
            }
        });
        sensorBuzz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Rung_dt.class);
                startActivity(intent);
            }
        });
        customview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Custom_view.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        sensorView = findViewById(R.id.sensorview);
        sensorBuzz = findViewById(R.id.sensorBuzz);
        customview = findViewById(R.id.customview);
    }
}
