package creational.builder;

public class Client {
    public static void main(String[] args) {
        Sandwich beefCucumberThickMayo = new Sandwich.SandwichBuilder()
                .vegetable(Vegetable.CUCUMBER)
                .bread(Bread.THICK)
                .protein(Protein.BEEF)
                .sauce(Sauce.MAYO)
                .build();
        beefCucumberThickMayo.getIngredients();
    }
}
