package com.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static void main(String[] args) {
		
		//Pattern p = new Pattern("[b-z]?");
		
		System.out.println(Pattern.matches("[b-z]?", "a"));
		
		System.out.println(Pattern.matches("[^b-z]?", "a"));
		
		System.out.println(Pattern.matches("[[a-f][m-t]]*", "denofp"));
		
		System.out.println(Pattern.matches("[[a-f][m-t]]+", "n"));
		
		System.out.println(Pattern.matches("[[a-f][m-t]]?", "g"));
		
		System.out.println(Pattern.matches("[a-g&&[^m-z]]*", "ff"));
		System.out.println(Pattern.matches("[a-g||[^m-z]]*", "hh"));
		 
        // Check if all the elements are in range a to z
        // or A to Z
		System.out.println("Check if all the elements are in range a to z");
        System.out.println(
            Pattern.matches("[a-zA-Z]+", "aaZZTg"));
 
        // Check if elements is not in range a to z
        System.out.println("Check if elements is not in range a to z");
        System.out.println(Pattern.matches("[^a-z]?", ""));
        System.out.println(Pattern.matches("[^a-z]?", "1"));
        System.out.println(Pattern.matches("[^a-z]?", "11"));
 
        // Check if all the elements are either g,e,k or s
        System.out.println("Check if all the elements are either g,e,k or s");
        System.out.println(Pattern.matches("[geks]+", "s"));
        System.out.println(Pattern.matches("[geks]+", "eg"));
        System.out.println(Pattern.matches("[geks]+", "abcd"));
        
        System.out.println("Checking first letter of evry word");
		String s1 = "Geeks for Geeks";
        String s2 = "A Computer Science Portal for Geeks";
        Pattern p = Pattern.compile("\\b[a-zA-Z]");
        Matcher m1 = p.matcher(s1);
        Matcher m2 = p.matcher(s2);
         
        System.out.println("First letter of each word from string \"" + s1 + "\" : ");
        while (m1.find())
            System.out.print(m1.group());
         
        System.out.println();
         
        System.out.println("First letter of each word from string \"" + s2 + "\" : ");
         
        while (m2.find()) 
            System.out.print(m2.group());

        System.out.println();
        
        Pattern p1 = Pattern.compile("\\B[a-zA-Z]");
        Matcher m11 = p1.matcher(s1);
        Matcher m22 = p1.matcher(s2);
         
        System.out.println("First letter of each word from string \"" + s1 + "\" : ");
        while (m11.find())
            System.out.print(m11.group());
         
        System.out.println();
         
        System.out.println("First letter of each word from string \"" + s2 + "\" : ");
         
        while (m22.find()) 
            System.out.print(m22.group());

	}

}
