package service;

import factory.Filter;

import models.ItemsQuantity;
import repository.InventoryRepository;

import java.util.ArrayList;
import java.util.List;

public class SearchItemService {

    public List<ItemsQuantity> searchItems(List<Filter> filterList) {

        List<ItemsQuantity> allItems = InventoryRepository.getAllItems();
        for(Filter filter: filterList){
            List<ItemsQuantity> itemsQuantities = new ArrayList<>();
            for(ItemsQuantity itemsQuantity: allItems){
                if(filter.applyFilter(itemsQuantity)){
                    itemsQuantities.add(itemsQuantity);
                }
            }
            allItems = itemsQuantities;
        }
        return allItems;
    }
}
