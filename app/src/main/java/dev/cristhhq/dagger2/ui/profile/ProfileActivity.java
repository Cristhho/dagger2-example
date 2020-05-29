package dev.cristhhq.dagger2.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dev.cristhhq.dagger2.R;

public class ProfileActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etEdad;
    private TextView tvLogout;
    private Button btnNextActivity;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initView();
    }

    private void initView() {
        etName = findViewById(R.id.etName);
        etEdad = findViewById(R.id.etAge);
        tvLogout = findViewById(R.id.tvLogout);
        btnNextActivity = findViewById(R.id.btNextActivity);
        btnSave = findViewById(R.id.btSave);
    }
}