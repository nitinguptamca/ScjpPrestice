package ocp.study.part1;

public class InnerClassDemo {

	private int x = 10;
	private static int staticX = 20;
	private int z;

	interface SomeInterface {
		void doSomething();
	}

	private class InnerClass{
		int a=100;
		///static int staticA=100; //The field staticA cannot be declared static in a non-static inner type, 
		//unless initialized with a constant expression
		public void display() {
			
		}
		InnerClass innerClass=new InnerClass();
	}
	public static void testLocalClassStatic() {
		int z = 9990;
		class MyInner {
			public void seeOuter() {
				System.out.println("staticX is " + staticX);
				staticX++;
				System.out.println("staticX is " + staticX);
				System.out.println("instance is " + z);
				// z++;
				// Cannot change z here;
				// we will get error message "local variables referenced from a lambda
				// expression must be final or effectively final".
				// z++;
			}
		}

		MyInner i = new MyInner();
		i.seeOuter();
	}

	public void testLocalClass() {

		class MyInner {
			public void seeOuter() {
				System.out.println("x is " + x++);
				z+=10;
				System.out.println("z is " + z++);
			}
		}

		MyInner i = new MyInner();
		i.seeOuter();
	}

	public void testAnonymousClass() {
		int y = 30;
		System.out.println("Anonymous Class");
		SomeInterface someInterface = new SomeInterface() {
			int z = 40;
			/// static int z1 = 42; // <-- Inner class cannot have static declarations
			static final int z2 = 42; // <-- OK

			@Override
			public void doSomething() {
				// y++; // y needs to be final
				x++;
				z++;
				staticX+=100;
				//y++;  Local variable y defined in an enclosing scope must be final or effectively final
				System.out.println("x = " + x);
				System.out.println("y = " + y);
				System.out.println("z = " + z);

				System.out.println("staticX is " + staticX);
			}
		};
		someInterface.doSomething();
	}

	public static void main(String[] args) {
		InnerClassDemo innerClassDemo = new InnerClassDemo();
		innerClassDemo.testLocalClass();
		InnerClassDemo.testLocalClassStatic();
		innerClassDemo.testAnonymousClass();
	}
}
