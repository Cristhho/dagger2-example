package dev.cristhhq.dagger2.api;

import java.util.List;

import dev.cristhhq.dagger2.model.GitHubRepo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiClient {

    @GET("/user/{user}/repos")
    Call<List<GitHubRepo>> getReposByUser(@Path("user")String user);
}
