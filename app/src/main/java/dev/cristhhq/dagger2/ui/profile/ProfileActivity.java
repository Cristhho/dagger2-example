package dev.cristhhq.dagger2.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import dev.cristhhq.dagger2.R;
import dev.cristhhq.dagger2.di.BaseApp;
import dev.cristhhq.dagger2.model.User;
import dev.cristhhq.dagger2.ui.login.LoginActivity;
import dev.cristhhq.dagger2.ui.webservice.WebServiceActivity;

public class ProfileActivity extends AppCompatActivity implements Profile.View {

    private EditText etName;
    private EditText etAge;
    private TextView tvLogout;
    private Button btnNextActivity;
    private Button btnSave;

    @Inject
    Profile.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ((BaseApp)getApplication()).getAppComponent().inject(this);

        initView();
        presenter.setView(this);
    }

    private void initView() {
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        tvLogout = findViewById(R.id.tvLogout);
        btnNextActivity = findViewById(R.id.btNextActivity);
        btnSave = findViewById(R.id.btSave);

        btnNextActivity.setOnClickListener(v ->
                startActivity(new Intent(this, WebServiceActivity.class)));

        btnSave.setOnClickListener(v -> {
            User user = new User();
            user.setUserName(etName.getText().toString());
            user.setAge(etAge.getText().toString());
            presenter.updateUser(user);
        });

        tvLogout.setOnClickListener(v -> presenter.logout());
    }

    @Override
    public void showUser(User user) {
        etName.setText(user.getUserName());
        etAge.setText(user.getAge());
    }

    @Override
    public void logout() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}