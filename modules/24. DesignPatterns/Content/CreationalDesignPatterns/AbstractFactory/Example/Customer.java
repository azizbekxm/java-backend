package Creational.AbstractFactoryDesignPattern;

public class Customer {
	public AbstractFood placeOrder(String itemName, int quantity, String itemType) {
		AbstractFoodFactory a = null;
		if (itemType.equals("italian")) {
			a = new ItalianFoodFactory();
		} else if (itemType.equals("chinese")) {
			a = new ItalianFoodFactory();
		}
		if (a != null) {
			return a.placeOrder(itemName, quantity);
		} else {
			return null;
		}
	}

}
