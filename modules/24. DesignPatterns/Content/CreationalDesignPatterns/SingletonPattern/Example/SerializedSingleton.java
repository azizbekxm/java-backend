package Creational.SingletonDesignPattern;

public class SerializedSingleton {

	private static final long serialVersionUID = -7604766932017737115L;

	private SerializedSingleton() {
	}

	private static class SingletonHelper {
		private static final SerializedSingleton instance = new SerializedSingleton();
	}

	public static SerializedSingleton getInstance() {
		return SingletonHelper.instance;
	}

	/*
	 * Deserialization destroys the singleton pattern, to overcome this scenario all
	 * we need to do it provide the implementation of readResolve() method.
	 **/
	protected Object readResolve() {
		return getInstance();
	}
}
