package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDetails {

    private CategoryBrandPair categoryBrandPair;
    private int mrp;
    private int price;

}
