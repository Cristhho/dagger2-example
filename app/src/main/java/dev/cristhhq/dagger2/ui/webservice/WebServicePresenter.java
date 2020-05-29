package dev.cristhhq.dagger2.ui.webservice;

import android.util.Log;

import java.util.List;

import dev.cristhhq.dagger2.api.ApiClient;
import dev.cristhhq.dagger2.model.GitHubRepo;
import dev.cristhhq.dagger2.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServicePresenter implements WebService.Presenter {

    private User user;
    private ApiClient api;
    private WebService.View view;

    public WebServicePresenter(User user, ApiClient apiClient){
        this.user = user;
        this.api = apiClient;
    }

    @Override
    public void setView(WebService.View view) {
        this.view = view;
        this.view.showUser(this.user);
    }

    @Override
    public void webServiceRequest() {
        Call<List<GitHubRepo>> call = api.getReposByUser("Cristhho");
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                for(int i = 0; i < response.body().size(); i++) {
                    GitHubRepo repo = response.body().get(i);
                    Log.i("WEB_SERVICE", "Repo: " + i + ", Nombre: " + repo.getName()
                            + ", Avatar: " + repo.getOwner().getAvatarUrl());
                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });
    }
}
