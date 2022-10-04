package turnstile;

import cards.CardType;

import java.util.Date;

public class TurnstileData {

    private CardType cardType;
    private String id;
    private boolean isSuccessfully;
    private Date date;

    public TurnstileData (CardType cardType, String id, boolean isSuccessfully, Date date) {
        this.cardType = cardType;
        this.id = id;
        this.isSuccessfully = isSuccessfully;
        this.date = date;
    }

    public CardType getCardType () {
        return cardType;
    }

    public String getId () {
        return id;
    }

    public boolean isSuccessfully () {
        return isSuccessfully;
    }

    public Date getDate () {
        return date;
    }
}
