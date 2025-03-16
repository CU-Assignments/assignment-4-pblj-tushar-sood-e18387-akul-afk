import java.util.*;

public class prob1 {
    private final Map<String, List<String>> cardCollection = new HashMap<>();
    public void addCard(String symbol, String cardName) {
        cardCollection.putIfAbsent(symbol, new ArrayList<>());
        cardCollection.get(symbol).add(cardName);
    }
    public void findCards(String symbol) {
        List<String> cards = cardCollection.get(symbol);
        if (cards == null || cards.isEmpty()) {
            System.out.println("No cards found for symbol: " + symbol);
        } else {
            System.out.println("Cards with symbol '" + symbol + "': " + cards);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        prob1 collection = new prob1();
        collection.addCard("Hearts", "Ace of Hearts");
        collection.addCard("Hearts", "King of Hearts");
        collection.addCard("Spades", "Queen of Spades");
        collection.addCard("Diamonds", "Jack of Diamonds");
        collection.addCard("Clubs", "10 of Clubs");

        System.out.print("Enter a symbol to search (e.g., Hearts, Spades): ");
        String symbol = scanner.nextLine();
        collection.findCards(symbol);
        scanner.close();
    }
}
