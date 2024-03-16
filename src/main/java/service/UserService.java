package service;

import models.User;
import repository.UserRepository;

public class UserService {

    public String addUser(User user) {
        if(user.getName() == null || user.getName().length() == 0){
            return "User name is invalid";
//            throw new IllegalArgumentException("User name is invalid");
        }
        // other validations on wallet balance
        return UserRepository.addUser(user);
    }
}
