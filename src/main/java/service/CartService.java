package service;

import models.CategoryBrandPair;
import models.ItemDetails;
import models.ItemsQuantity;
import models.User;
import repository.CartRepository;
import repository.InventoryRepository;
import repository.UserRepository;

import java.util.Map;

public class CartService {

    public String addToUserCart(String username, CategoryBrandPair categoryBrandPair, int quantity) {
        User user = UserRepository.getUserDetails(username);

        if(user == null){
            return "User does not exist";
        }
        double walletAmount = user.getWalletAmount();
        ItemsQuantity itemsQuantity = InventoryRepository.getItemDetails(categoryBrandPair);
        int inQuantity = itemsQuantity.getQuantity();

        if(inQuantity < quantity){
            return "Inventory quantity is not sufficient";
        }

        boolean isPossible = canAddToCart(walletAmount, itemsQuantity.getItemDetails(), quantity);
        if(!isPossible){
            return "Wallet balance not enough";
        }
        UserRepository.updateUserBalance(user, itemsQuantity.getItemDetails().getPrice()*quantity);
        InventoryRepository.deduceInventory(categoryBrandPair, quantity);
        return CartRepository.addToUserCart(username, categoryBrandPair, quantity);
    }

    private boolean canAddToCart(double walletAmount, ItemDetails itemDetails, int quantity) {

        int totalAmount = itemDetails.getPrice()*quantity;
        return totalAmount <= walletAmount;
    }

    public Map<CategoryBrandPair, Integer> getUserCart(String username) {
        return CartRepository.getUserCart(username);
    }
}
