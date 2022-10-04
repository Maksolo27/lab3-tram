package cards;

public abstract class Card {

    protected String id;
    protected final double DEFAULT_PRICE = 10.0;
    protected double balance;

    public CardType getCardType () {
        return cardType;
    }

    protected CardType cardType;

    public abstract boolean use ();

    public void setId(String  id){
        this.id = id;
    }

    public String getId () {
        return id;
    }

    public void replenish(double balance) {
        this.balance += balance;
    }

    public double getBalance () {
        return balance;
    }
}
