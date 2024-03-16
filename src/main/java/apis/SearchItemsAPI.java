package apis;

import factory.Filter;
import factory.FilterFactory;
import models.ItemsQuantity;
import service.SearchItemService;

import java.util.List;

public class SearchItemsAPI {

    private SearchItemService searchItemService = new SearchItemService();

    public List<ItemsQuantity> searchItems(List<String> brands, List<String> category,
                                           Integer minPrice, Integer maxPrice, Integer minQuantity, Integer maxQuantity){

        List<Filter> filterList = FilterFactory.getAllFilters(brands, category, minPrice, maxPrice, minQuantity, maxQuantity);
        return searchItemService.searchItems(filterList);
    }

}
