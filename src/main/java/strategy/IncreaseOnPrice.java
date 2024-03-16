package strategy;

public class IncreaseOnPrice implements PricingStrategy{

    private final int increasedPercentage;

    public IncreaseOnPrice(int increasedPercentage) {
        this.increasedPercentage = increasedPercentage;
    }

    @Override
    public int updatePrice() {
        return 0;
    }
}
