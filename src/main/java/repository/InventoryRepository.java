package repository;

import models.CategoryBrandPair;
import models.ItemDetails;
import models.ItemsQuantity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryRepository {

    private final static Map<CategoryBrandPair, ItemsQuantity> itemsQuantityMap = new HashMap<>();

    private InventoryRepository(){}

    public static String addItem(ItemDetails itemDetails) {

        itemsQuantityMap.put(itemDetails.getCategoryBrandPair(), new ItemsQuantity(itemDetails));
        return "Successfully added item details";
    }

    public static String addItemToInventory(CategoryBrandPair categoryBrandPair, int quantity) {

        ItemsQuantity itemsQuantity = itemsQuantityMap.get(categoryBrandPair);
        itemsQuantity.addQuantity(quantity);
        return "Successfully added item to inventory";

    }

    public static String deduceInventory(CategoryBrandPair categoryBrandPair, int quantity) {

        ItemsQuantity itemsQuantity = itemsQuantityMap.get(categoryBrandPair);
        itemsQuantity.deduceQuantity(quantity);
        return "Successfully added item to inventory";

    }

    public static ItemsQuantity getItemDetails(CategoryBrandPair categoryBrandPair) {
        return itemsQuantityMap.get(categoryBrandPair);
    }

    public static String updatePrice(CategoryBrandPair categoryBrandPair, int price) {
        ItemDetails itemDetails = itemsQuantityMap.get(categoryBrandPair).getItemDetails();
        itemDetails.setPrice(price);
        return "Successfully updated price";
    }

    public static List<ItemsQuantity> getAllItems() {

        List<ItemsQuantity> items = new ArrayList<>();
        for(Map.Entry<CategoryBrandPair, ItemsQuantity> map : itemsQuantityMap.entrySet()){
            items.add(map.getValue());
        }
        return items;
    }

    public static void printInventory() {
        for(Map.Entry<CategoryBrandPair, ItemsQuantity> map : itemsQuantityMap.entrySet()){
            ItemsQuantity itemsQuantity = map.getValue();
            ItemDetails itemDetails = itemsQuantity.getItemDetails();
            System.out.println(itemDetails.getCategoryBrandPair().getBrand() + " " +
                    itemDetails.getCategoryBrandPair().getCategory()
                    + " " + itemsQuantity.getQuantity() + " " + itemDetails.getPrice());
        }
    }
}
