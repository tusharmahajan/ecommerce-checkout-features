package factory;

import java.util.ArrayList;
import java.util.List;

public class FilterFactory {

    private FilterFactory(){}

    public static List<Filter> getAllFilters(List<String> brands, List<String> category,
                                             Integer minPrice, Integer maxPrice, Integer minQuantity, Integer maxQuantity) {
        List<Filter> filterList = new ArrayList<>();

        if(brands != null){
            filterList.add(new BrandFilter(brands));
        }

        if(category != null){
            filterList.add(new CategoryFilter(category));
        }

        if(minPrice != null && maxPrice != null){
            filterList.add(new PriceRangeFilter(minPrice, maxPrice));
        }

        if(minQuantity != null && maxQuantity != null){
            filterList.add(new QuantityFilter(minQuantity, maxQuantity));
        }
        return filterList;
    }
}
