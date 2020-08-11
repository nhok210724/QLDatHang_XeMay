package tdc.edu.vn.exe2;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class view_sensor extends AppCompatActivity {
    SensorManager sensorManager;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sensor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();
    }

    private void setEvent() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ArrayList sensorlist = new ArrayList<String>();
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor iSensor : sensors) {
            sensorlist.add(iSensor.getName() + " : " + iSensor.getVendor());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, sensorlist);
        lv.setAdapter(arrayAdapter);
    }

    private void setControl() {
        lv = findViewById(R.id.lvSensor);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
