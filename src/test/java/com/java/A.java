package com.java;

public class A {
	
	public class Bsub extends A{
		Bsub(){
			System.out.println("Constructor B"); 
		}
	}
	
	public class Csub extends B{
		Csub(){
			System.out.println("Constructor C");
		}
	}
	
	public final int z = 10;
	public final int y;
	public final String finalString = "Hello";
	public String str1 = "str1";
	public int i =10;

	A(){
		y = 0;
		System.out.println("Constructor A called");
	}
	
	public final void display() {
		System.out.println("A's display from final method");
	}
	
	public static void display(int x) {
		System.out.println("A's display param x from static method");
	}

	private static void displayPrivate(int x) {
		System.out.println("A's display param x from private method");
	}
	
	public void exceptionChk() {
		
		B b1 = new B();
		b1.exceptionChk();
		
	}
	
	public static void main(String[] args) {
		A a1 = new A();
		
		A a2 = a1;
		
		System.out.println(a1.finalString);
		try {
			System.out.println(a2.finalString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("a1 :"+ a1.str1 + "  "+a1.i);		
		System.out.println("a2 :"+ a2.str1 + "  "+a2.i);
		
		System.out.println("changed by a1");
		a1.str1 = "changed by a1";
		a1.i = 20;
		
		System.out.println("a1 :"+ a1.str1 + "  "+a1.i);		
		System.out.println("a2 :"+ a2.str1 + "  "+a2.i);
		
		
		System.out.println("changed by a2");
		a2.str1 = "changed by a2";
		a2.i = 30;
		
		System.out.println("a1 :"+ a1.str1 + "  "+a1.i);		
		System.out.println("a2 :"+ a2.str1 + "  "+a2.i);
		
		A a3 = new A();
		
		System.out.println("a3 copies values from a1");
		a3.str1 = a1.str1;
		a3.i = a1.i;
		
		System.out.println("a3 :"+ a3.str1 + "  "+a3.i);
		System.out.println("a3 changes its values");
		
		a3.str1 = "changed by a3";
		a3.i = 40;
		System.out.println("a3 :"+ a3.str1 + "  "+a3.i);
		System.out.println("a1 :"+ a1.str1 + "  "+a1.i);		
		System.out.println("a2 :"+ a2.str1 + "  "+a2.i);
		a3.exceptionChk();

	}
	
}