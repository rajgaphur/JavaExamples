package com.corejava.enumurations;

public class EnumDemo1 {

	public static void main(String[] args) {
		
		Apple ap;
		
		Apple.GoldenDel.display();

		for (Apple a : Apple.values()) {
			System.out.println(a.ordinal());
		}
				
		for (Apple a : Apple.values()) {
			a.display();
			
		}
	}

}
