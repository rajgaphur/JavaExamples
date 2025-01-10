package com.java;

public class AbstractA extends AbstractB{
	
	//public abstract void abs();  //The abstract method abs in type AbstractA can only be defined by an abstract class
	
	public int get() {
		return 0;
	}

	@Override
	void abstractMeth1() {
		System.out.println("Write your code");
	}
	
	public static void main(String[] args) {
		AbstractA a = new AbstractA();
		AbstractB b = new AbstractA();
		a.abstractMeth1();
		b.methPublic();
		methStatic();
		b.methProtected();
	}
	
}
