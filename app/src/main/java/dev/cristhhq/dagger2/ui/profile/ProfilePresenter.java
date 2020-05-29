package dev.cristhhq.dagger2.ui.profile;

import dev.cristhhq.dagger2.model.User;

public class ProfilePresenter implements Profile.Presenter {

    private User user;
    private Profile.View view;

    public ProfilePresenter(User user){
        this.user = user;
    }

    @Override
    public void setView(Profile.View view) {
        this.view = view;
        view.showUser(user);
    }

    @Override
    public void updateUser(User updateUser) {
        user.setUserName(updateUser.getUserName());
        user.setAge(updateUser.getAge());
    }

    @Override
    public void logout() {
        user.setUserName("");
        user.setAge("");
        view.logout();
    }
}
