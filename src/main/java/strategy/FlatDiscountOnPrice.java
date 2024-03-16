package strategy;

public class FlatDiscountOnPrice implements PricingStrategy{

    private final int flatDiscount;

    public FlatDiscountOnPrice(int flatDiscount) {
        this.flatDiscount = flatDiscount;
    }

    @Override
    public int updatePrice() {
        return 0;
    }
}
