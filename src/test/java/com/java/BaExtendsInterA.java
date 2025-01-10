package com.java;

public class BaExtendsInterA implements InterfaceA{

	public static void main(String[] args) {
		
		BaExtendsInterA bi = null;
		bi.abstractMethod();
		
		bi.defaultM("Hi");
	}
	
	public void abstractMethods() {
	}

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
	
	

}
