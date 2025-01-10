package com.java;

//protected interface InterfaceA {
//Illegal modifier for the interface InterfaceA; only public & abstract are permitted
public interface InterfaceA {
	
	public final static int x = 1;
	final static public int y = 1;
	static public final int z = 1;
	
	
	//InterfaceA ia = new InterfaceA(); //Cannot instantiate the type InterfaceA
	
	
	//Static int e = 0;  //"Syntax error on token "Static", static expected"
	//Public int f = 1; //"Syntax error on token "Public", public expected"   
	//Final int g = 1;  //Syntax error on token "Final", final expected
	
	int xy = 1;  // "By default, variables are of type final"
	public void display();
	
	public String rev(String word);
	
	//public abstract static void abstractMethod();
	/*Illegal combination of modifiers for the interface method abstractMethod; 
	only one of abstract, default, or static permitted*/
	public abstract void abstractMethod();
	
	//public default void abstractMethod1();
	//This method requires a body instead of a semicolon
	
	//static String staticMethod(String s);
	//This method requires a body instead of a semicolon
	
	default String defaultM(String str) {
		System.out.println("Print :"+str);
		//xy = x +1;  //"The final field InterfaceA.xy cannot be assigned" "By default, variables are of type final"
		System.out.println(xy);
		return str;
	}
	
	//protected String protectedMethod(String s);
	//Illegal modifier for the interface method protectedMethod; 
	//only public, abstract, default, static and strictfp are permitted
	public String protectedMethod(String s);
	
	//private String privateMethod(String s);
	//Illegal modifier for the interface method privateMethod; 
	//only public, abstract, default, static and strictfp are permitted
	public String privateMethod(String s);
	
	//static String staticMethod1(String s);
	//This method requires a body instead of a semicolon
	
	static String staticMethod2(String s) {
		System.out.println("Print :"+s);
		return s;
	}

}