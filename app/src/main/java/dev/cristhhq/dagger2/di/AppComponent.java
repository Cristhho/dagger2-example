package dev.cristhhq.dagger2.di;

import javax.inject.Singleton;

import dagger.Component;
import dev.cristhhq.dagger2.ui.login.LoginActivity;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(LoginActivity loginActivity);
}
