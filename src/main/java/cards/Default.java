package cards;

public class Default extends Card {

    public Default () {
        super.cardType = CardType.DEFAULT;
    }

    @Override
    public boolean use () {
        if (balance >= DEFAULT_PRICE) {
            balance -= DEFAULT_PRICE;
            return true;
        } else {
            return false;
        }
    }

}
