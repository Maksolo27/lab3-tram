package cards;

public class Student extends Preferential {

    private final int discount;

    public Student () {
        discount = 50;
        cardType = CardType.STUDENT;
    }


    @Override
    protected double useDiscountPrice () {
        return DEFAULT_PRICE / 100 * discount;
    }
}
