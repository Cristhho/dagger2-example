package dev.cristhhq.dagger2.ui.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import dev.cristhhq.dagger2.R;
import dev.cristhhq.dagger2.di.BaseApp;
import dev.cristhhq.dagger2.model.User;

public class WebServiceActivity extends AppCompatActivity implements WebService.View {

    private Button btBacToProfile;
    private Button btDoRequest;
    private TextView tvUserName;
    private TextView tvAge;

    @Inject
    WebService.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);
        ((BaseApp)getApplication()).getAppComponent().inject(this);

        initView();
        presenter.setView(this);
    }

    private void initView() {
        tvUserName = findViewById(R.id.tvUserName);
        tvAge = findViewById(R.id.tvAge);
        btBacToProfile = findViewById(R.id.btBackToProfile);
        btDoRequest = findViewById(R.id.btRequest);

        btBacToProfile.setOnClickListener(v -> onBackPressed());
        btDoRequest.setOnClickListener(v ->
            presenter.webServiceRequest());
    }

    @Override
    public void showUser(User user) {
        tvUserName.setText(user.getUserName());
        tvAge.setText(user.getAge());
    }
}