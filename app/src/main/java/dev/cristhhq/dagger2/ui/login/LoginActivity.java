package dev.cristhhq.dagger2.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import dev.cristhhq.dagger2.R;
import dev.cristhhq.dagger2.di.BaseApp;
import dev.cristhhq.dagger2.ui.profile.ProfileActivity;

public class LoginActivity extends AppCompatActivity implements Login.View {

    private EditText etUser;
    private EditText etPassword;
    private Button btnLogin;

    @Inject
    Login.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ((BaseApp)getApplication()).getAppComponent().inject(this);

        initView();
    }

    private void initView() {
        presenter.setView(this);

        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btLogin);

        btnLogin.setOnClickListener(v ->
                presenter.validateUser(
                        etUser.getText().toString(),
                        etPassword.getText().toString()
                ));
    }

    @Override
    public void validUser() {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    @Override
    public void error() {
        Toast.makeText(this, "User is not valid", Toast.LENGTH_SHORT).show();
    }
}
