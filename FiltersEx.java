package com.corejava.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FiltersEx {

	public static void main(String[] args) {

		ArrayList<Integer> arrInt = new ArrayList<Integer>();
		
		arrInt.add(5);
		arrInt.add(15);
		arrInt.add(20);
		arrInt.add(25);
		arrInt.add(30);
		arrInt.add(35);
		
		
		System.out.println(arrInt);
		
		
				
		List<Integer> arrInt1 = Arrays.asList(5,15,20,25,30,35);
		System.out.println("--------------------------");
		System.out.println(arrInt1);

		//Without Streams - Separate list of even numbers
		List<Integer> evenArrInt1 = new ArrayList<Integer>();
		for (Integer integer : arrInt1) {
			if(integer%2==0) {
				evenArrInt1.add(integer);
			}
		}
		System.out.println("---------Even Arrays1---------");
		System.out.println(evenArrInt1);
		
		//With Stream APIs
		List<Integer> evenArrInt2 = new ArrayList<Integer>();
		evenArrInt2 = arrInt1.stream().filter((n)->n%2==0).collect(Collectors.toList());
		System.out.println("---------Even Arrays2---------");
		System.out.println(evenArrInt2);
		
		//OR other way to print
		System.out.println("-----Even Arrays2 with foreach Consumer-----");
		arrInt1.stream().filter((n)->n%2==0).forEach(n->System.out.print(n+", "));
		
		//OR other way to print
		System.out.println();
		System.out.println("-----Even Arrays2 with foreach System.out::println-----");
		arrInt1.stream().filter((n)->n%2==0).forEach(System.out::println);
		
		
	}

}
