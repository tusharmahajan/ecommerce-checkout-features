package repository;

import models.CategoryBrandPair;

import java.util.HashMap;
import java.util.Map;

public class CartRepository {

    private final static Map<String, Map<CategoryBrandPair, Integer>> cartDetailsMap = new HashMap<>();

    private CartRepository(){}

    public static String addToUserCart(String username, CategoryBrandPair categoryBrandPair, int quantity) {
        cartDetailsMap.putIfAbsent(username, new HashMap<>());
        Map<CategoryBrandPair, Integer> cartDetails = cartDetailsMap.get(username);
        cartDetails.put(categoryBrandPair, quantity);
        return "Successfully added to cart";
    }

    public static Map<CategoryBrandPair, Integer> getUserCart(String username){
        return cartDetailsMap.get(username);
    }
}
