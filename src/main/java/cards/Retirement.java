package cards;

public class Retirement extends Preferential {

    private final int discount;

    public Retirement () {
        discount = 70;
        cardType = CardType.RETIREMENT;
    }

    @Override
    protected double useDiscountPrice () {
        return DEFAULT_PRICE / 100 * discount;

    }
}
