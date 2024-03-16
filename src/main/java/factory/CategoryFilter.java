package factory;

import models.ItemsQuantity;

import java.util.List;

public class CategoryFilter implements Filter{

    private final List<String> category;

    public CategoryFilter(List<String> category) {
        this.category = category;
    }

    @Override
    public boolean applyFilter(ItemsQuantity itemsQuantity) {
        String inCategory = itemsQuantity.getItemDetails().getCategoryBrandPair().getCategory();
        for(String c: category){
            if(c.equals(inCategory)) return true;
        }
        return false;
    }
}
