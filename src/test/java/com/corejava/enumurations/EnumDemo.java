package com.corejava.enumurations;

import java.util.Iterator;

public class EnumDemo {

	public static void main(String[] args) {
		
		Apple ap;
		
		System.out.println("Apple contents");
		Apple[] appleVal = Apple.values();
		for (Apple apple : appleVal) {
			System.out.println(apple);
			apple.display();
			
		}

		ap = Apple.RedDel;
		
		System.out.println(ap);
	}

}
