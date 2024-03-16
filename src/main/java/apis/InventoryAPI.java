package apis;

import models.CategoryBrandPair;
import models.ItemDetails;
import service.InventoryService;

public class InventoryAPI {

    private final InventoryService inventoryService = new InventoryService();

    public String addItemsDetails(ItemDetails itemDetails){
        return inventoryService.addItem(itemDetails);
    }

    public String addItemsToInventory(CategoryBrandPair categoryBrandPair, int quantity){
        return inventoryService.addItemToInventory(categoryBrandPair, quantity);
    }

    public String updatePrice(CategoryBrandPair categoryBrandPair, int price){
        return inventoryService.updatePrice(categoryBrandPair, price);
    }
}
