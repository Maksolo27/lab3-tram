package cards;

public class Schooler extends Preferential {

    private final int discount;

    public Schooler () {
        discount = 90;
        cardType = CardType.SCHOOLER;
    }


    @Override
    protected double useDiscountPrice () {
        return DEFAULT_PRICE / 100 * discount;
    }
}
