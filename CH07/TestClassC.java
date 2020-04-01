class TestClassC extends TestClassB {
	void m3() {
		System.out.print("C’s m3, " + (ivar + 6));
	}

	void line(){
		System.out.println(" ");
	}

	public static void main(String[] args) {
		TestClassA a = new TestClassA();
		TestClassB b = new TestClassB();
		TestClassC c = new TestClassC();
		TestClassA a2 = new TestClassC();
		b.m1();		c.m2();		a.m3();
		c.line();
		
		c.m1();
		c.m2();
		c.m3();
		c.line();

		a.m1();
		b.m2();
		c.m3();
		c.line();
		
		a2.m1();
		a2.m2();
		a2.m3();
	}
}