package Creational.SingletonDesignPattern;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;

	// private Constructor
	private ThreadSafeSingleton() {
	}

	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}

	public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
		if (instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}

	public void message() {
		System.out.println("ThreadSafe singleton");
	}

	public void messageDoubleLocking() {
		System.out.println("ThreadSafe singleton with Double Locking");
	}
}
