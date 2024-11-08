package Creational.AbstractFactoryDesignPattern;

import java.util.ArrayList;

public class AbstractFactoryMain {
	ArrayList order;

	public static void main(String[] args) {
		AbstractFactoryMain m = new AbstractFactoryMain();
		m.createOrder();
	}

	public boolean createOrder() {
		boolean orderCreated = false;
		Customer c = new Customer();
		order = new ArrayList();
		order.add(c.placeOrder("Lazagne", 2, "italian"));
		order.add(c.placeOrder("Taco", 3, "mexican"));
		order.add(c.placeOrder("Noodles", 1, "chinese"));
		System.out.println(order);
		return orderCreated;
	}
}
