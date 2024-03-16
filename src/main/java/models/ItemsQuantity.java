package models;

import lombok.Data;

@Data
public class ItemsQuantity {

    private ItemDetails itemDetails;
    private int quantity = 0;

    public ItemsQuantity(ItemDetails itemDetails) {
        this.itemDetails = itemDetails;
        this.quantity = 0;
    }

    public void addQuantity(int quantity) {
        this.quantity+=quantity;
    }

    public void deduceQuantity(int quantity) {
        this.quantity-=quantity;
    }
}
