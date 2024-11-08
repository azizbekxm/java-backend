package Creational.FactoryDesignPattern;

public class Monthly implements Membership {

	@Override
	public void payment() {
		System.out.println("Your amount for monthly subscription is 100$");
	}
}
