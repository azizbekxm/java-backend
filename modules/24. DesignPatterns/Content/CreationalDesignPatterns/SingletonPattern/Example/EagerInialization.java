package Creational.SingletonDesignPattern;

public class EagerInialization {
	// public instance initialized when loading the class
	private static final EagerInialization instance = new EagerInialization();

	// private Constructor
	private EagerInialization() {

	}

	public static EagerInialization getInstance() {
		return instance;
	}

	public void showMessage() {
		System.out.println("This is Eager Initialization");
	}

}
