package cards;

public abstract class Preferential extends Card {

    private int discount;

    @Override
    public boolean use () {
        if (balance >= useDiscountPrice ()) {
            balance -= useDiscountPrice ();
            return true;
        } else {
            return false;
        }
    }

    protected abstract double useDiscountPrice ();

}
