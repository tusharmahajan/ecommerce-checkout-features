import apis.CartAPI;
import apis.InventoryAPI;
import apis.SearchItemsAPI;
import apis.UserAPI;
import models.CategoryBrandPair;
import models.ItemDetails;
import models.User;
import models.UserType;
import repository.InventoryRepository;

import java.util.Map;

// 1. add better exception handling
// 2. Dont interactive repository of other services to directly interact with other service.
// Eg Cart service should not interact with Inventory repo, User repo etc directly.
// Use Inventory service, User service as intermediary
// Model classes in better way like Inventory quantity is not required.

public class FlipkartDailySimulator {

    private static UserAPI userAPI = new UserAPI();
    private static CartAPI cartAPI = new CartAPI();
    private static InventoryAPI inventoryAPI = new InventoryAPI();
    private static SearchItemsAPI searchItemsAPI = new SearchItemsAPI();

    private static CategoryBrandPair categoryBrandPair1 = new CategoryBrandPair("amul", "milk");
    private static CategoryBrandPair categoryBrandPair2 = new CategoryBrandPair("amul", "curd");
    private static CategoryBrandPair categoryBrandPair3 = new CategoryBrandPair("nestle", "milk");
    private static CategoryBrandPair categoryBrandPair4 = new CategoryBrandPair("nestle", "curd");

    public static void main(String[] args) {
        addUsers();
        addItemsToInventory();
        addToCart();
        updateItem();
        getUserCart();
        InventoryRepository.printInventory();
    }

    private static void getUserCart() {
        Map<CategoryBrandPair, Integer> userCart =  cartAPI.getUserCart("tushar");
        for(Map.Entry<CategoryBrandPair, Integer> cart: userCart.entrySet()){
            System.out.println(cart.getKey().getBrand() + " " + cart.getKey().getCategory() + " "+ cart.getValue());
        }
    }

    private static void updateItem() {
        inventoryAPI.updatePrice(categoryBrandPair3, 80);
    }

    private static void addToCart() {
        cartAPI.addToUserCart("tushar", categoryBrandPair3, 5);
        cartAPI.addToUserCart("rahul", categoryBrandPair3, 12);
    }

    private static void addItemsToInventory() {

        ItemDetails itemDetails1 = new ItemDetails(categoryBrandPair1, 120, 100);
        ItemDetails itemDetails2 = new ItemDetails(categoryBrandPair2, 60, 50);
        ItemDetails itemDetails3 = new ItemDetails(categoryBrandPair3, 70, 60);
        ItemDetails itemDetails4 = new ItemDetails(categoryBrandPair4, 100, 90);

        inventoryAPI.addItemsDetails(itemDetails1);
        inventoryAPI.addItemsDetails(itemDetails2);
        inventoryAPI.addItemsDetails(itemDetails3);
        inventoryAPI.addItemsDetails(itemDetails4);

        inventoryAPI.addItemsToInventory(categoryBrandPair1, 10);
        inventoryAPI.addItemsToInventory(categoryBrandPair3, 5);
        inventoryAPI.addItemsToInventory(categoryBrandPair4, 10);
        inventoryAPI.addItemsToInventory(categoryBrandPair3, 30);
        inventoryAPI.addItemsToInventory(categoryBrandPair2, 5);
        InventoryRepository.printInventory();
    }


    private static void addUsers() {
        User user1 = new User("tushar", "xyz@gmail.com", UserType.ADMIN, 600);
        User user2 = new User("rahul", "xyz1@gmail.com", UserType.ADMIN, 500);
        User user3 = new User("manoj", "xyz2@gmail.com", UserType.ADMIN, 3000);
        userAPI.addUser(user1);
        userAPI.addUser(user2);
        userAPI.addUser(user3);
    }
}
