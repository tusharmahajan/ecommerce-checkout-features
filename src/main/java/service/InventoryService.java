package service;

import models.CategoryBrandPair;
import models.ItemDetails;
import repository.InventoryRepository;

public class InventoryService {

    public String addItem(ItemDetails itemDetails) {
        return InventoryRepository.addItem(itemDetails);
    }

    public String addItemToInventory(CategoryBrandPair categoryBrandPair, int quantity) {
        return InventoryRepository.addItemToInventory(categoryBrandPair, quantity);
    }

    public String updatePrice(CategoryBrandPair categoryBrandPair, int price) {
        return InventoryRepository.updatePrice(categoryBrandPair, price);
    }
}
