package repository;

import models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    // Keeping username as unique identifier
    private static final Map<String, User> userDetails = new HashMap<>();

    private UserRepository(){}


    public static String addUser(User user) {
        userDetails.put(user.getName(), user);
        return "Successfully added user: " + user.getName();
    }

    public static User getUserDetails(String username) {
        return userDetails.get(username);
    }

    public static void updateUserBalance(User user, int deduceAmount) {
        user.setWalletAmount(user.getWalletAmount()-deduceAmount);
    }
}
