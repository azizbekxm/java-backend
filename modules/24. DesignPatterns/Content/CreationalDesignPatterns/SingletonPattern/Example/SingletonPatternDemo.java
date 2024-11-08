package Creational.SingletonDesignPattern;

public class SingletonPatternDemo {
	public static void main(String... args) {
		EagerInialization eagerObject = EagerInialization.getInstance();
		eagerObject.showMessage();

		LazyInitialization lazyObject = LazyInitialization.getInstance();
		lazyObject.showMessage();

		ThreadSafeSingleton threadsafe = ThreadSafeSingleton.getInstance();
		threadsafe.message();

		ThreadSafeSingleton doubleLock = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
		doubleLock.messageDoubleLocking();
	}

}
