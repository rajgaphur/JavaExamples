package com.corejava.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapEx {

	public static void main(String[] args) {

		//ArrayList<String> arrStr = new ArrayList<String>();

		List<String> arrStr = Arrays.asList("abdul", "bhai", "don", "koun");
		
		System.out.println("-----------------------------------------");
		System.out.println(arrStr);
		
		//Without Map stream
		System.out.println("---------------Uppercase without Map StreamAPI-----------------");
		for (String string : arrStr) {
			System.out.print(string.toUpperCase()+ ", ");
		}
		System.out.println();
				
		//With Map Stream
		List<String> upperArrStr = new ArrayList<String>();
		//upperArrStr = arrStr.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
		upperArrStr = arrStr.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println("---------------Uppercase with Map StreamAPI-----------------");
		System.out.println(upperArrStr);
		
		//OR
		
		arrStr.stream().map(s->s.toUpperCase()).forEach(str->System.out.print(str+", "));
		
		System.out.println();
		arrStr.stream().map(s->s.toUpperCase()).forEach(System.out::println);
	}

}
