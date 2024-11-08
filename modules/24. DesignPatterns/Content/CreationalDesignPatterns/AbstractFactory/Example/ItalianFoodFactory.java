package Creational.AbstractFactoryDesignPattern;

public class ItalianFoodFactory extends AbstractFoodFactory {

	@Override
	public AbstractFood placeOrder(String itemName, int quantity) {
		return new ItalianFood(itemName, quantity);
	}

}