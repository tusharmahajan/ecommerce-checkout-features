package factory;

import models.ItemsQuantity;

public class PriceRangeFilter implements Filter{

    private final int minPrice;
    private final int maxPrice;

    public PriceRangeFilter(int minPrice, int maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean applyFilter(ItemsQuantity itemsQuantity) {
        int inPrice = itemsQuantity.getItemDetails().getPrice();
        return inPrice >= minPrice && inPrice <= maxPrice;
    }
}
