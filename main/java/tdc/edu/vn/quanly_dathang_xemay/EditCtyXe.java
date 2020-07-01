package tdc.edu.vn.quanly_dathang_xemay;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditCtyXe extends AppCompatActivity {

    Button btnTroVe;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_ctyxe);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setControl() {
        btnTroVe = findViewById(R.id.btnTroVe);
    }
}
