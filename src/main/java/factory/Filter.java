package factory;

import models.ItemsQuantity;

public interface Filter {

    boolean applyFilter(ItemsQuantity itemsQuantity);
}
