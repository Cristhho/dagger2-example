package dev.cristhhq.dagger2.ui.login;

public interface Login {

    interface View{
        void validUser();
        void error();
    }

    interface Presenter{
        void setView(Login.View view);
        void validateUser(String user, String pass);
    }

}
