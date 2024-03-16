package apis;

import models.User;
import service.UserService;

public class UserAPI {

    private final UserService userService = new UserService();

    public String addUser(User user){
        return userService.addUser(user);
    }
}
