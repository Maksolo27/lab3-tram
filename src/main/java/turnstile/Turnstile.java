package turnstile;

import cards.Card;
import cards.CardSystem;
import cards.CardType;
import encrypt.EncryptService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class Turnstile {

    private final EncryptService encryptService = new EncryptService ();
    private final CardSystem cardSystem = CardSystem.getInstance ();
    private final List<TurnstileData> turnstileDataList = new ArrayList<> ();


    private boolean validateCard (Card card) {
        String cardId = card.getId ();
        return cardSystem.getEncryptedIds ().stream ()
                .anyMatch (id -> encryptService.validatePassword(cardId, id) );
    }

    public boolean pass (Card card) {
        boolean result = false;
        if (validateCard (card)) {
            result = card.use ();
        }
        turnstileDataList.add (new TurnstileData (card.getCardType (), card.getId (), result, new Date ()));
        return result;
    }


    public void printSummary () {
        System.out.println ("Number of pass: " + turnstileDataList.size ());
        int numberOfAccept = (int) turnstileDataList.stream ().filter (TurnstileData::isSuccessfully).count ();
        System.out.println ("Number of accept: " + numberOfAccept);
        System.out.println ("Number of reject: " + (turnstileDataList.size () - numberOfAccept));
    }

    public void printSummaryByCardType (CardType cardType) {
        List<TurnstileData> turnstileDataByCardType = turnstileDataList.stream ()
                .filter (d -> cardType == d.getCardType ())
                .collect(Collectors.toList());
        System.out.println ("Number of pass: " + turnstileDataByCardType.size ());
        int numberOfAccept = (int) turnstileDataByCardType.stream ().filter (TurnstileData::isSuccessfully).count ();
        System.out.println ("Number of accept: " + numberOfAccept);
        System.out.println ("Number of reject: " + (turnstileDataByCardType.size () - numberOfAccept));
    }
}
