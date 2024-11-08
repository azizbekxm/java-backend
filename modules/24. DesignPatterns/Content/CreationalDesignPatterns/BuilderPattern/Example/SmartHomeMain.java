package Creational.BuilderDesignPattern;

import Creational.BuilderDesignPattern.SmartHome.SmartHomeBuilder;

public class SmartHomeMain {
	public static void main(String... args) throws Exception {
		SmartHome sm1 = new SmartHomeBuilder().addressName("NewYork").build();
		SmartHome sm2 = new SmartHomeBuilder().addressName("House2").addressNumber("212").city("London")
				.country("England").build();

		System.out.println(sm1);
		System.out.println(sm2);
	}

}
