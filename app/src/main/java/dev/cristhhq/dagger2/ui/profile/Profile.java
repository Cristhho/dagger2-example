package dev.cristhhq.dagger2.ui.profile;

import dev.cristhhq.dagger2.model.User;

public interface Profile {
    interface View{
        void showUser(User user);
        void logout();
    }

    interface Presenter{
        void setView(Profile.View view);
        void updateUser(User updateUser);
        void logout();
    }
}
