package com.java.collections.collection;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.AbstractQueue;
import java.util.AbstractSequentialList;
import java.util.AbstractSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class CollectinEx1 {


	public static void main(String[] args) {
		CollectinEx1 ce = new CollectinEx1();

 //public interface Iterable<T> {
  //Collection - public interface Collection<E> extends Iterable<E> {
	//List - public interface List<E> extends Collection<E> {
		//LinkedList - public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable {
		//ArrayList -  public class ArrayList<E>  extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
		//Vector -     public class Vector<E>     extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
		  //Stack -    public class Stack<E>      extends Vector<E> {
		
	//Queue - public interface Queue<E> extends Collection<E> {
		//Deque - public interface Deque<E> extends Queue<E> {
		  //ArrayDeque<E> - public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable
		//PriorityQueue<E> - public class PriorityQueue<E> extends AbstractQueue<E> implements java.io.Serializable {
		
	//Set - public interface Set<E> extends Collection<E> {
		//HashSet - public class HashSet<E> extends AbstractSet<E>   implements Set<E>, Cloneable, java.io.Serializable {
		  //LinkedHashSet<E> public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, java.io.Serializable {
		//SortedSet<E>- public interface SortedSet<E> extends Set<E> {
		  //TreeSet  - public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, java.io.Serializable {
		
		
		ce.remDuplicateString();
		System.out.println("============================================================================");
		ce.palindromeEx1();
		System.out.println("============================================================================");
		ce.arrListEx1();
		System.out.println("============================================================================");
		ce.arrayListEx();
		System.out.println("============================================================================");
		ce.linkedListEx();
		System.out.println("============================================================================");
		ce.hashSet();
		System.out.println("============================================================================");
		ce.treeSet();
		System.out.println("============================================================================");
		ce.hashMap();
		System.out.println("============================================================================");
		ce.treeMap();
		System.out.println("============================================================================");

	}
	
	public void remDuplicateString() {
		
		String str= "lseg lseg banagalore lseg";
		System.out.println("Input String :"+str);
		String newStr = "";

		String[] strArr = str.split(" ");
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		//HashSet<String> lhs = new HashSet<String>();
		
		for(String word: strArr){

			/*
			if(!newStr.contains(word)){
				newStr += word+" ";
			}*/
			System.out.println(word);
			System.out.println("Adding word '"+word+"' "+lhs.add(word));
			
		}
		//System.out.println(newStr);
		System.out.println(lhs.toString());
		System.out.println(lhs.size());
		
		for (String string : lhs) {
			newStr += string + " ";
		}
		
		System.out.println("Output String :"+newStr.trim());
		
	}
	
	
	public void palindromeEx1() {
		
		String initStr = "racecarannakayakradar";
		System.out.println("Input String :"+initStr);
		//String initStr = "abc";
		String str = initStr;
		
		int i =0;
		String temp = "";
		ArrayList<String> al = new ArrayList<String>();
		while(i<str.length()) {
			temp += str.charAt(i++);
			
			if(isPalindrome(temp)) {
				al.add(temp);				
				str = str.substring(i);
				System.out.println("Left String :"+str);
				temp ="";
				i=0;
			}
		}
		
		if(al.isEmpty()) {
			for(int l=0;l<initStr.length();l++) {
				System.out.print(initStr.charAt(l)+" ");
			}
		}else {
			for (String string : al) {
				System.out.print(string+" ");
			}
		}
		System.out.println();
	}
	
	public boolean isPalindrome(String string) {
		StringBuffer sb = new StringBuffer(string);
		String strRev = sb.reverse().toString();
		System.out.println(string+"<-->"+strRev);
		if(string.equalsIgnoreCase(strRev) && strRev.length()>1) {
			return true;
		}
		return false;
	}
	
	public void arrListEx1() {
		int[] intArr = {5, 4, 3, 5, 5, 5, 3, 3, 3, 6};
		
		displayArr(intArr);
		int occurCount = 0, y =0;
		System.out.println("---using linkedhashmap----");
		//HashMap<Integer,Integer> storeArr = new HashMap<Integer,Integer>();
		LinkedHashMap<Integer,Integer> storeArr = new LinkedHashMap<Integer,Integer>();
		for(int i=0; i<intArr.length; i++){
			occurCount = 0;
			for(int j=0;j<intArr.length;j++) {
				if(intArr[i]==intArr[j]) {
					occurCount++;
				}
			}
			
			storeArr.put(intArr[i],occurCount);	
		}
		
		for(Integer key: storeArr.keySet()){
		
			System.out.println(key+"="+storeArr.get(key));
		
		}
		
		System.out.println("---using linked hashmap V1----");
		for(int i=0; i<intArr.length; i++){
			
			occurCount = 0;
			for (int j = i+1; j < intArr.length; j++) {
				if(intArr[i]==intArr[j]) {
					occurCount++;
				}
			}
			if(!storeArr.containsKey(intArr[i])) {
				storeArr.put(intArr[i],occurCount);
			}
				
		}
		
		Set<Integer> itr = storeArr.keySet();
		
		
		for(Integer key: itr){
			System.out.println(key+"="+storeArr.get(key));
		
		}
		/*  // java.lang.ClassCastException: class java.util.LinkedHashMap$LinkedKeySet cannot be cast to class java.util.Iterator
		Iterator<Integer> it = (Iterator<Integer>) storeArr.keySet();
		while(it.hasNext()) {
			System.out.println(it.next()+"="+storeArr.get(it.next()));
		}*/
	}
	
	public void displayArr(int[] arr) {
		System.out.println("-------Array Contents Start-----");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("-------Array Contents End-----");
	}
	
	
	public void arrayListEx() {
		ArrayList<String> aLstr = new ArrayList<String>();
		
		aLstr.add("CD");
		aLstr.add("AB");
		aLstr.add("GH");
		aLstr.add("EF");
		aLstr.add("EF");
		//aLstr.add(null);  //Can have null values 
		//Cant perform Collections.sort(aLstr) as java.lang.NullPointerException: Cannot invoke "java.lang.Comparable.compareTo(Object)" because "pivot" is null
		displayArrList(aLstr);
		//---------
		aLstr.add(1, "BB");
		aLstr.add(5, "IJ");
		displayArrList(aLstr);
		
		System.out.println(aLstr.get(1));
		
		aLstr.set(5, "II");
		System.out.println(aLstr.get(5));
		
		aLstr.remove(2);
		System.out.println("--------Revised----------");
		displayArrList(aLstr);

		System.out.println("--------UnSorted----------");
		System.out.println(aLstr);
		System.out.println("--------Sorted----------");
		Collections.sort(aLstr);
		System.out.println(aLstr);
		
		System.out.println("--------Copy to other Arraylist----------");
		ArrayList<String> aLstr1 = new ArrayList<String>();
		
		aLstr1.addAll(aLstr);
		System.out.println("Copied   :"+aLstr1);
		
		Collections.reverse(aLstr1);
		System.out.println("Reversed :"+aLstr1);
		
		ArrayList<String> aLstr2 = new ArrayList<String>();
		aLstr2.addAll(aLstr1);
		aLstr2.addAll(aLstr);
		
		System.out.println("Joined aLstr2 = aLstr1 + aLstr");
		System.out.println(aLstr2);
		
		System.out.println("Joined aLstr and  aLstr1");
		aLstr.addAll(aLstr.size(), aLstr1);		
		System.out.println(aLstr);
		
		System.out.println("Empty aLstr");
		System.out.println("Removed array? :"+aLstr.removeAll(aLstr));
		System.out.println("Removed list :"+aLstr);
		
		System.out.println("Is Empty Array? :"+(aLstr.isEmpty()? "Yes": "No"));
		
	}
	
	public void displayArrList(ArrayList<String> al) {
		Iterator<String> itr = al.iterator();

		System.out.println("--------start----------");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("--------end------------");
	}

	public void linkedListEx() {
		//ArrayList<String> aLstr = new ArrayList<String>();
		LinkedList<String> sLstr = new LinkedList<String>();
		sLstr.add("CD");
		sLstr.add("AB");
		sLstr.add("GH");
		sLstr.add("EF");
		sLstr.add("IJ");
		sLstr.add("LM");
		
		Iterator<String> itr = sLstr.listIterator();
		
		System.out.println("------------------");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("------------------");
		for (String string : sLstr) {
			System.out.println(string);
		}
		System.out.println("IrReverse :"+sLstr);
		Collections.reverse(sLstr);
		System.out.println("Reverse :"+sLstr);
		
		Collections.sort(sLstr);
		System.out.println("Sorted :"+sLstr);
		
		Collections.shuffle(sLstr);
		System.out.println("Shuffled :"+sLstr);
		
		sLstr.addFirst("YY");
		sLstr.addLast("AA");
		
		System.out.println("Updated :"+sLstr);
		
		sLstr.add(0, "BB");
		System.out.println("Updated :"+sLstr);
		
		sLstr.add(sLstr.size(), "ZZ");
		System.out.println("Updated :"+sLstr);
		
		
	}
	
	public void hashSet() {
		
		HashSet<String> hs = new HashSet<String>();
/*		
		hs.add("cd");
		hs.add("ab");
		hs.add("ij");
		hs.add("cd");
		hs.add("bc");
		hs.add("ef");
*/		
		System.out.println(hs.add("cd"));
		System.out.println(hs.add("ab"));
		System.out.println(hs.add("ij"));
		System.out.println(hs.add("cd"));
		System.out.println(hs.add("bc"));
		System.out.println(hs.add("ef"));

		System.out.println("HashSet :"+hs);
		
		String[] arr = new String[hs.size()];
		hs.toArray(arr);
		for (String string : arr) {
			System.out.print(" "+string);
		}
		System.out.println();
		
		hs.clear();
		System.out.println("Clear :"+hs);
	}
	
	public void treeSet() {
		
		TreeSet<String> ts = new TreeSet<String>();
/*		
		hs.add("cd");
		hs.add("ab");
		hs.add("ij");
		hs.add("cd");
		hs.add("bc");
		hs.add("ef");
*/		
		System.out.println(ts.add("cd"));
		System.out.println(ts.add("ab"));
		System.out.println(ts.add("ij"));
		System.out.println(ts.add("cd"));
		System.out.println(ts.add("bc"));
		System.out.println(ts.add("ef"));

		System.out.println("TreeSet :"+ts);
				
		String[] arr = new String[ts.size()];
		ts.toArray(arr);
		for (String string : arr) {
			System.out.print(" "+string);
		}
		System.out.println();
		
		ts.clear();
		System.out.println("Clear :"+ts);

	}
	
	public void hashMap() {
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		//HashMap<List<String>, List<String>> hMapList = new HashMap<List<String>, List<String>>();
		
		System.out.println(hMap.put(1, "GH"));
		System.out.println(hMap.put(2, "BC"));
		System.out.println(hMap.put(3, "DE"));
		System.out.println(hMap.put(4, "FI"));
		System.out.println(hMap.put(5, "EF"));
		System.out.println(hMap.put(5, "IJ"));
		
		System.out.println(hMap);
		
		System.out.println("Display Using keySet()");
		Set<Integer> itr = hMap.keySet();
		
		for (Integer integer : itr) {
			System.out.print(hMap.get(integer)+" ");
		}
		System.out.println();
		
		System.out.println("Display Using Values()");
		Collection<String> val = hMap.values();
		for (String string : val) {
			System.out.print(string+" ");
		}
		System.out.println();
		
		System.out.println("Display Using entrySet()");
		Set<Entry<Integer, String>> entrySet = hMap.entrySet();
		
		for (Entry<Integer, String> entry : entrySet) {
			System.out.print(entry.getKey()+"="+entry.getValue()+" ");
		}
		System.out.println();

	}
	
	
	public void treeMap() {
		TreeMap<Integer, String> tMap = new TreeMap<Integer, String>();
		
		System.out.println(tMap.put(4, "GH"));
		System.out.println(tMap.put(2, "BC"));
		System.out.println(tMap.put(1, "DE"));
		System.out.println(tMap.put(5, "FI"));
		System.out.println(tMap.put(3, "EF"));
		System.out.println(tMap.put(3, "KF"));
		
		System.out.println(tMap);
		
		System.out.println("Using keySet()");
		Set<Integer> itr = tMap.keySet();		
		for (Integer integer : itr) {
			System.out.print(tMap.get(integer)+" ");
		}
		System.out.println();
		System.out.println("Using Values()");
		Collection<String> val = tMap.values();
		for (String string : val) {
			System.out.print(string+" ");
		}
		System.out.println();
	}
}




