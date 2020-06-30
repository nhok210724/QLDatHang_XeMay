package tdc.edu.vn.quanly_dathang_xemay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Resgister extends AppCompatActivity {
    //New Control
    EditText etuser, etpass, etcomfirm;
    Button btnsubmit, btnexit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgister);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setControl() {
        etuser = findViewById(R.id.etInputUser2);
        etpass = findViewById(R.id.etInputPass2);
        etcomfirm = findViewById(R.id.etInputPass3);
        btnsubmit = findViewById(R.id.btnComfirm);
        btnexit = findViewById(R.id.btnExit2);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
