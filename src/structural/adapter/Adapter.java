package structural.adapter;

/**
 * Adapter is a structural design pattern that convert the interface
 * of a class into another interface clients expect.
 * Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
 *
 */
public class Adapter {
    public static void main(String[] args) {
        VietnameseTarget client = new TranslatorAdapter(new JapaneseAdaptee());
        client.send("Con chồn màu xanh");
    }
}
class TranslatorAdapter implements VietnameseTarget{
    JapaneseAdaptee japaneseAdaptee;
    TranslatorAdapter (JapaneseAdaptee adaptee) {
        japaneseAdaptee = adaptee;
    }
    @Override
    public void send(String word) {
        System.out.println("Reading word...");
        System.out.println(word);
        String japaneseWord = translate(word);
        System.out.println("Sending word...");
        japaneseAdaptee.receive(japaneseWord);
    }
    private String translate(String vietnameseWord) {
        System.out.println("Translated!");
        return "Doremon";
    }
}
class JapaneseAdaptee {
    void receive(String word) {
        System.out.println("Retrieving word from Adapter...");
        System.out.println(word);
    }
}
interface VietnameseTarget {
    void send(String word);
}

