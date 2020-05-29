package dev.cristhhq.dagger2.di;

import javax.inject.Singleton;

import dagger.Component;
import dev.cristhhq.dagger2.ui.login.LoginActivity;
import dev.cristhhq.dagger2.ui.profile.ProfileActivity;
import dev.cristhhq.dagger2.ui.webservice.WebServiceActivity;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(LoginActivity loginActivity);
    void inject(ProfileActivity profileActivity);
    void inject(WebServiceActivity webServiceActivity);
}
