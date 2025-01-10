package com.java;

public class TestInterfaceABC implements InterfaceA, InterfaceB, InterfaceC{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

/*
	@Override
	static String staticMethod(String s) { //The method staticMethod(String) of type TestInterfaceABC must override or 
										   //implement a supertype method
		System.out.println("Print :"+s);
		return s;
	}
*/
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String rev(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void abstractMethod() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String protectedMethod(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String privateMethod(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String search(String word) {
		// TODO Auto-generated method stub
		return null;
	}

}
