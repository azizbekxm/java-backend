package Creational.AbstractFactoryDesignPattern;

public abstract class AbstractFoodFactory {
	public abstract AbstractFood placeOrder(String itemName, int quantity);
}
