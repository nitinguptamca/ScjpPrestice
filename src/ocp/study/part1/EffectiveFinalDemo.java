package ocp.study.part1;

/**
 * Now in Java 8, if you try to reassign a new value to our non-final local
 * variable, the compiler will again complain about the error "local variables
 * referenced from an inner class must be final or effectively final".
 * 
 * You can see that we can access "effectiveFinal" variable without any issue in
 * the lambda expression. Now just try to assign this variable a new value
 * before lambda, just to make it non-final and see what happens, you will
 * receive an error "local variables referenced from a lambda expression must be
 * final or effectively final".
 *
 */
public class EffectiveFinalDemo {

	public static void main111(String args[]) {
		String nonFinal = "I am non final local variable";
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Using non-final local variable inside anonymous class in Java");
				System.out.println("Value of non-final variable is : " + nonFinal);

				// compile time error - must be final or effective final
				// nonFinal = "Can I change non-final variable inside anonymous class";
			}
		};

		Thread t = new Thread(r);
		t.start();
	}

	public static void main(String args[]) {
		String effectiveFinal = "I am non final local variable";
		Runnable r = () -> {
			// effectiveFinal="Nitin Kumar Gupta";
			// local variables referenced from a lambda expression must be final or
			// effectively final
			System.out.println("Value of effectively variable is : " + effectiveFinal);
		};

		Thread t = new Thread(r);
		t.start();
	}

}
