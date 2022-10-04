package cards;


public class TripAmount extends Card {

    private int tripNumbers;

    public TripAmount (int tripNumbers) {
        this.tripNumbers = tripNumbers;
        cardType = CardType.TRIP_AMOUNT;
    }

    public TripAmount () {
        cardType = CardType.TRIP_AMOUNT;
    }

    @Override
    public boolean use () {
        if (tripNumbers > 0) {
            tripNumbers--;
            return true;
        }
        return false;
    }

    public void extend (int tripNumbers) {
        this.tripNumbers += tripNumbers;
    }

    @Override
    public void replenish (double balance) {
        int trips = (int) (balance * DEFAULT_PRICE);
        this.tripNumbers += trips;
    }

}
