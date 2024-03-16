package factory;

import models.ItemsQuantity;

import java.util.List;

public class BrandFilter implements Filter{

    private final List<String> brand;

    public BrandFilter(List<String> brand) {
        this.brand = brand;
    }

    @Override
    public boolean applyFilter(ItemsQuantity itemsQuantity) {
        String inBrand = itemsQuantity.getItemDetails().getCategoryBrandPair().getBrand();
        for(String b: brand){
            if(b.equals(inBrand)) return true;
        }
        return false;
    }
}
