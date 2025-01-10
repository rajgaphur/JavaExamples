package com.java;

public class DemoClass {

	 public static void main(String args[]) {
	     Child demoObject=new Child();
	     demoObject.foo();
	     
	     Parent p2 = new Child();
	     p2.display();
	     
	     Parent p1 = new Parent();
	     p1.display();
	     
	     Child c2 = new Child();
	     c2.display();
	     
	     //com.java.Parent cannot be cast to com.java.Child
	     Child c1 = (Child) new Parent();
	     c1.display();
	     
	     /*
	      This would print - 
	      Parent class parameterised constructor.
	      Child class default Constructor
	      Child class foo!
	      Parent class foo!
	     */
	    }
}
