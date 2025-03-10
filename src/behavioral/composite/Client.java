package behavioral.composite;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        FileComponent a = new File("a.txt", 10);
        FileComponent b = new File("b.txt", 10);
        FileComponent c = new Folder(List.of(a));

        FileComponent d = new Folder(List.of(b,c));
        System.out.println(d.totalSize());
        d.showProperties();
    }
}
