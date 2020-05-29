package dev.cristhhq.dagger2.ui.webservice;

import dev.cristhhq.dagger2.model.User;

public interface WebService {

    interface View{
        void showUser(User user);
    }

    interface Presenter{
        void setView(WebService.View view);
        void webServiceRequest();
    }
}
