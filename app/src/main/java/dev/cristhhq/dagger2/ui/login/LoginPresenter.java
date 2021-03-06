package dev.cristhhq.dagger2.ui.login;

import dev.cristhhq.dagger2.model.User;

public class LoginPresenter implements Login.Presenter {

    private Login.View view;

    private User user;

    public LoginPresenter(User user) {
        this.user = user;
    }

    @Override
    public void setView(Login.View view) {
        this.view = view;
    }

    @Override
    public void validateUser(String user, String pass) {
        if (view != null) {
            if(user.equals("christian")&&pass.equals("1234")){
                this.user.setUserName("Christian Ochoa");
                this.user.setAge("25");
                view.validUser();
            }else{
                view.error();
            }
        }
    }
}
