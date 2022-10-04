package cards;

import java.util.Date;

public class Temporary extends Card {

    private Date endDate = new Date ();

    public Temporary (int days) {
        endDate.setHours (new Date ().getHours () + ( days * 24 ));
        cardType = CardType.TEMPORARY;
    }

    public Temporary () {
        endDate.setHours (new Date ().getHours () + ( 10 * 24 ));
        cardType = CardType.TEMPORARY;
    }

    @Override
    public boolean use () {
        return new Date ().getTime () <= endDate.getTime ();
    }


    @Override
    public void replenish (double balance) {
        int days = (int) (balance * DEFAULT_PRICE);
        endDate.setHours (endDate.getHours () + (days * 24));
    }
}
