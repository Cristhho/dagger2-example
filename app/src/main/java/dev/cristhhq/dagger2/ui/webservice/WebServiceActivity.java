package dev.cristhhq.dagger2.ui.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import dev.cristhhq.dagger2.R;

public class WebServiceActivity extends AppCompatActivity {

    private Button btBacToProfile;
    private Button btDoRequest;
    private TextView tvUserName;
    private TextView tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        initView();
    }

    private void initView() {
        tvUserName = findViewById(R.id.tvUserName);
        tvAge = findViewById(R.id.tvAge);
        btBacToProfile = findViewById(R.id.btBackToProfile);
        btDoRequest = findViewById(R.id.btRequest);
    }
}