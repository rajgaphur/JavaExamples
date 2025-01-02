package com.corejava.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapEx {

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1,2);
		List<Integer> list2 = Arrays.asList(3,4);
		List<Integer> list3 = Arrays.asList(5,6);
		
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		List<List<Integer>> grpList = Arrays.asList(list1, list2, list3);
		
		//FlatMap
		List<Integer> combinedList = grpList.stream().flatMap(list->list.stream()).collect(Collectors.toList());
		System.out.println(combinedList);
		
		//Complex operation
		List<Integer> complexList = grpList.stream().flatMap(list->list.stream().map(i->i*5)).collect(Collectors.toList());
		System.out.println(complexList);

	}

}
