package creational.builder;

public class Sandwich {
    private final Protein protein;
    private final Sauce sauce;
    private final Bread bread;
    private final Vegetable vegetable;

    private Sandwich(SandwichBuilder builder) {
        this.protein = builder.protein;
        this.sauce = builder.sauce;
        this.bread = builder.bread;
        this.vegetable = builder.vegetable;
    }

    public void getIngredients() {
        System.out.println(bread.name() + " " + protein.name() + " " + sauce.name() + " " + vegetable.name());
    }

    // Static Nested Builder Class
    public static class SandwichBuilder {
        private Protein protein;
        private Sauce sauce;
        private Bread bread;
        private Vegetable vegetable;

        public SandwichBuilder protein(Protein protein) {
            this.protein = protein;
            return this;
        }

        public SandwichBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public SandwichBuilder bread(Bread bread) {
            this.bread = bread;
            return this;
        }

        public SandwichBuilder vegetable(Vegetable vegetable) {
            this.vegetable = vegetable;
            return this;
        }

        public Sandwich build() {
            // Validate required fields
            if (bread == null || protein == null) {
                throw new IllegalStateException("Bread and Protein are required!");
            }
            return new Sandwich(this);
        }
    }
}
