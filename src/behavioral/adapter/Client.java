package behavioral.adapter;

public class Client {
    public static void main(String[] args) {
        JsonTarget target = new ConvertAdapter(new XmlAdaptee());
        target.request("{a:b}");
    }
}
