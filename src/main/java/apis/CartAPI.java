package apis;

import models.CategoryBrandPair;
import service.CartService;

import java.util.Map;

public class CartAPI {

    private final CartService cartService = new CartService();

    public String addToUserCart(String username, CategoryBrandPair categoryBrandPair, int quantity){
        return cartService.addToUserCart(username, categoryBrandPair, quantity);
    }

    public Map<CategoryBrandPair, Integer> getUserCart(String username){
        return cartService.getUserCart(username);
    }
}
