package cards;

import encrypt.EncryptService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardSystem {

    private final EncryptService encryptService = new EncryptService ();
    private final List<Card> cards = new ArrayList<> ();

    public List<String> getEncryptedIds () {
        return encryptedIds;
    }

    private final List<String> encryptedIds = new ArrayList<> ();

    private static CardSystem instance;

    private CardSystem(){}

    public static CardSystem getInstance() {
        if(instance == null){
            instance = new CardSystem ();
        }
        return instance;
    }

    public Card createCard (CardType cardType) {
        Card card = new CardFactory ().getCard (cardType);
        String id = getRandomString (16);
        String encryptedId = generateId (id);
        card.setId (id);
        encryptedIds.add (encryptedId);
        cards.add (card);
        return card;
    }

    public void updateCard (Card card) {
        cards.remove (getCard (card.getId ()));
        cards.add (card);
    }

    private String generateId(String id) {
        return encryptService.encryptId (id);
    }

    private String getRandomString(int length) {
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random ();
        StringBuilder sb = new StringBuilder ();
        String result;
        boolean isDublicated;
        do {
            for(int i = 0; i < length; i++){
                int number = random.nextInt(str.length ());
                sb.append(str.charAt(number));
            }
            result = sb.toString();
            isDublicated = encryptedIds.contains (encryptService.encryptId (result));
        } while (isDublicated);
        return result;
    }

    public Card getCard (String id) {
        Card resultCard = null;
        for (int i = 0; i < cards.size (); i++) {
            Card card = cards.get (i);
            if (card.getId ().equals (id)) {
                resultCard = card;
                return resultCard;
            }
        }
        return resultCard;

    }



}
