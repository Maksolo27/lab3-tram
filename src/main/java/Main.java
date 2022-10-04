import cards.Card;
import cards.CardSystem;
import cards.CardType;
import turnstile.Turnstile;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        CardSystem cardSystem = CardSystem.getInstance ();
        Turnstile turnstile = new Turnstile ();
        Scanner scanner = new Scanner (System.in);
        while (true) {
            scanner = new Scanner (System.in);
            System.out.println ("Print 1 - to create new card");
            System.out.println ("Print 2 - to use your card");
            System.out.println ("Print 3 - to extend your card");
            System.out.println ("Print 4 - to print info");
            System.out.println ("Print 5 - to print your balance");
            String command = scanner.nextLine ();
            switch (command) {
                case "1" -> {
                    System.out.println ("Type your card type");
                    Arrays.stream (CardType.values ()).forEach (System.out::println);
                    scanner = new Scanner (System.in);
                    CardType cardType = CardType.valueOf (scanner.nextLine ());
                    Card card2 = cardSystem.createCard (cardType);
                    System.out.println ("Your card id:");
                    System.out.println (card2.getId ());
                    System.out.println ();
                }
                case "2" -> {
                    System.out.println ("Input your card id");
                    scanner = new Scanner (System.in);
                    String cardId = scanner.nextLine ();
                    Card card = cardSystem.getCard (cardId);
                    boolean useCard = turnstile.pass (card);
                    if (useCard) {
                        System.out.println ("Successfully used");
                    } else {
                        System.out.println ("Error");
                    }
                }
                case "3" -> {
                    System.out.println ("Input your card id");
                    scanner = new Scanner (System.in);
                    String cardId1 = scanner.nextLine ();
                    Card card1 = cardSystem.getCard (cardId1);
                    scanner = new Scanner (System.in);
                    System.out.println ("Input your sum");
                    String balance = scanner.nextLine ();
                    card1.replenish (Double.parseDouble (balance));
                    cardSystem.updateCard (card1);
                }
                case "4" -> turnstile.printSummary ();
                case "5" -> {
                    System.out.println ("Input your card id");
                    scanner = new Scanner (System.in);
                    String cardId2 = scanner.nextLine ();
                    System.out.println (cardSystem.getCard (cardId2).getBalance ());
                }
            }
        }
    }
}
