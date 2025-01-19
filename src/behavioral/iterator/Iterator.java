package behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * provide a way to access the elements of an aggregate object sequentially without
 * knowing the underlying details
 */
interface ItemsIterator<T> {
    boolean hasNext();
    T next();
}
class Item {
    private String url;
    private String title;

    public Item(String url, String title) {
        this.url = url;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Item{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
class Menu {
    private List<Item> menuItems = new ArrayList<>();
    public void addItem(Item item) {
        menuItems.add(item);
    }
    public ItemsIterator<Item> iterator() {
        return new MenuItemsIterator();
    }
    class MenuItemsIterator implements ItemsIterator<Item> {
        private int curIdx = 0;
        @Override
        public boolean hasNext() {
            return curIdx < menuItems.size();
        }

        @Override
        public Item next() {
            return menuItems.get(curIdx++);
        }
    }
}
class Client {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addItem(new Item("Home", "/home"));
        menu.addItem(new Item("Java", "/java"));
        menu.addItem(new Item("Spring Boot", "/spring-boot"));

        ItemsIterator<Item> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            System.out.println(item);
        }
    }
}

