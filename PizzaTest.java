/*SLIP 1:

 * Write a Java Program to implement Factory method for Pizza Store with createPizza(), 
 * orederPizza(), prepare(), Bake(), cut(), box(). Use this to create variety of pizza’s 
 * like NyStyleCheesePizza, ChicagoStyleCheesePizza etc.
 */
// Pizza interface
interface Pizza {
    void prepare();
    void bake();
    void cut();
    void box();
}

// Concrete class for NY Style Cheese Pizza
class NyStyleCheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing NY Style Cheese Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking NY Style Cheese Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting NY Style Cheese Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing NY Style Cheese Pizza");
    }
}

// Concrete class for Chicago Style Cheese Pizza
class ChicagoStyleCheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Chicago Style Cheese Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Chicago Style Cheese Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Chicago Style Cheese Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing Chicago Style Cheese Pizza");
    }
}

// PizzaStore class with Factory Method
abstract class PizzaStore {
    // Factory method
    abstract Pizza createPizza(String type);

    // Order pizza method
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}

// Concrete PizzaStore class for NY Style Pizza
class NYPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NyStyleCheesePizza();
        }
        // Add more pizza types as needed
        return null;
    }
}

// Concrete PizzaStore class for Chicago Style Pizza
class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        }
        // Add more pizza types as needed
        return null;
    }
}

// Main class
public class PizzaTest {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza nyCheesePizza = nyStore.orderPizza("cheese");
        System.out.println("\n");

        Pizza chicagoCheesePizza = chicagoStore.orderPizza("cheese");
    }
}
