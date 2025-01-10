package com.java;

abstract class AbstractB {
	
	int i = 1;
	
	//AbstractB ab = new AbstractB(); //Cannot instantiate the type AbstractB
	
	abstract void abstractMeth1();
	
	private void meth1() {
		i = i +1;
		System.out.println("Hi");
	}
	
	public String methPublic() {
		System.out.println("In public method of Abstract Class");
		return "Salam";
	}
	
	static void methStatic() {
		System.out.println("In static method of Abstract Class");
	}
	
	protected void methProtected() {
		System.out.println("In protected method of Abstract Class");
	}
}
