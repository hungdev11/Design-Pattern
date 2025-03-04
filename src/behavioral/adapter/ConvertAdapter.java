package behavioral.adapter;

public class ConvertAdapter implements JsonTarget{
    private XmlAdaptee adaptee;
    public ConvertAdapter(XmlAdaptee adaptee) {
        this.adaptee = adaptee;
    }
    @Override
    public void request(String data) {
        System.out.println("Data, do something with that data");
        System.out.println("Convert XML to JSON...");
        String convertedData = convertJsonToXml(data);
        System.out.println("Send data");
        adaptee.specificRequest(convertedData);
    }
    private String convertJsonToXml(String data) {
        return "<a>b</a>";
    }
}
