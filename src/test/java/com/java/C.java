package com.java;

public class C extends A{

	public static void display(int x) {
		System.out.println("C's display param x from static method");
	}

	private static void displayPrivate(int x) {
		System.out.println("C's display param x from private method");
	}

	C(){
		System.out.println("Constructor C called");
	}
	public static void main(String[] args) {

		C c = new C();
		
		c.display(5);
		c.displayPrivate(10);
	}

}
