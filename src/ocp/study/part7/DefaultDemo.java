package ocp.study.part7;

public class DefaultDemo {

	@FunctionalInterface
	interface One {
		void doIt();

		public default void doSomething() {
			System.out.println("I - One: Do something");
		}

		default void doSomething2() {
			System.out.println("I - One: Do something2");
		}

		static void display() {
			System.out.println("I  -One Display ");
		}

	}

	// Two is NOT a @FunctionalInterface -> Two SAMs
	interface Two extends One {
		// Redefined it now
		default void doSomething() {
			System.out.println("I - Two: Do something");
		}

		/*default void doSomething2() {
			System.out.println("I - One: Do something2");
		}
*/
		// doSomething2 is now abstract..you cant get the default impl now
		void doSomething2();

		static void display1() {
			System.out.println("I  -Two Display1 ");
		}
	}

	static class OneTest implements One {

		@Override
		public void doIt() {
			System.out.println("C - OneTest: Do it");
		}

		@Override
		public void doSomething() {
			System.out.println("C - OneTest: Do something");
		}

	}

	static class TwoTest implements Two {

		@Override
		public void doIt() {
			System.out.println("C - TwoTest: Do it");
		}

		@Override
		public void doSomething2() {
			System.out.println("C - TwoTest: Do something");
		}
	}

	public static void main(String[] args) {
		One one = new OneTest();
		one.doIt();
		one.doSomething();
		one.doSomething2();
		One.display();
	

		Two two = new TwoTest();
		two.doIt();
		two.doSomething();
		two.doSomething2();
		Two.display1();
	}
}
