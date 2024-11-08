package Creational.FactoryDesignPattern;

public class Annual implements Membership {

	@Override
	public void payment() {
		System.out.println("You opted for Annual. Please pay the amount 800$");
	}

}
