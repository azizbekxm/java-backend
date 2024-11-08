package Creational.FactoryDesignPattern;

public class Quarterly implements Membership {

	@Override
	public void payment() {
		System.out.println("Quarterly membership fee will be 200$");
	}

}
