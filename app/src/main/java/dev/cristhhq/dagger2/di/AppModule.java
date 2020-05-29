package dev.cristhhq.dagger2.di;

import android.app.Application;
import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.cristhhq.dagger2.api.ApiClient;
import dev.cristhhq.dagger2.model.User;
import dev.cristhhq.dagger2.ui.login.Login;
import dev.cristhhq.dagger2.ui.login.LoginPresenter;
import dev.cristhhq.dagger2.ui.profile.Profile;
import dev.cristhhq.dagger2.ui.profile.ProfilePresenter;
import dev.cristhhq.dagger2.ui.webservice.WebService;
import dev.cristhhq.dagger2.ui.webservice.WebServicePresenter;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    public User provideUser() {
        return new User();
    }

    private static final String BASE_URL = "https://api.github.com";

    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverter() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory converterFactory) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();
    }

    @Singleton
    @Provides
    public ApiClient provideApiCliente(Retrofit retrofit) {
        return retrofit.create(ApiClient.class);
    }

    @Provides
    @Singleton
    public Login.Presenter provideLoginPresenter(User user) {
        return new LoginPresenter(user);
    }

    @Provides
    @Singleton
    public Profile.Presenter provideProfilePresenter(User user) {
        return new ProfilePresenter(user);
    }

    @Provides
    @Singleton
    public WebService.Presenter provideWebServicePresenter(User user, ApiClient apiClient) {
        return new WebServicePresenter(user, apiClient);
    }

}
