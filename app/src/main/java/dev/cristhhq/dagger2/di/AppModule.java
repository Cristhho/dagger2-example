package dev.cristhhq.dagger2.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.cristhhq.dagger2.model.User;
import dev.cristhhq.dagger2.ui.login.Login;
import dev.cristhhq.dagger2.ui.login.LoginPresenter;

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

    @Provides
    @Singleton
    public Login.Presenter provideLoginPresenter(User user) {
        return new LoginPresenter(user);
    }

}
