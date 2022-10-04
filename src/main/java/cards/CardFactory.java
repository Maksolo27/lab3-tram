package cards;

public class CardFactory {


    public Card getCard(CardType cardType) {
        switch (cardType){
            case STUDENT -> {
                return new Student ();
            }
            case RETIREMENT -> {
                return new Retirement ();
            }
            case SCHOOLER -> {
                return new Schooler ();
            }
            case TEMPORARY -> {
                return new Temporary ();
            }
            case TRIP_AMOUNT -> {
                return new TripAmount ();
            }
            default -> {
                return new Default ();
            }
        }
    }
}
