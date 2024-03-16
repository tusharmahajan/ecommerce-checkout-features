package factory;

import models.ItemsQuantity;

public class QuantityFilter implements Filter {

    private final int minQuantity;
    private final int maxQuantity;

    public QuantityFilter(int minQuantity, int maxQuantity) {
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
    }

    @Override
    public boolean applyFilter(ItemsQuantity itemsQuantity) {
        int inQuantity = itemsQuantity.getQuantity();
        return inQuantity >= minQuantity && inQuantity <= maxQuantity;
    }
}
