package com.corejava.Math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class MathExamples {

	public static void main(String[] args) {

		MathExamples mat = new MathExamples();

		System.out.println("Math Examples");
		mat.sortIntArr();
		System.out.println("============================================================================");
		mat.removduplicateinArr();
		System.out.println("============================================================================");
		mat.uniqueIntArr();
		System.out.println("============================================================================");
		mat.missingInteger();
		System.out.println("============================================================================");
		mat.missingNumber1();
		System.out.println("============================================================================");
		mat.trailingZerosInFactorial();
		System.out.println("============================================================================");
		mat.trailingZerosInFactorial1();
		System.out.println("============================================================================");
		mat.simpleFraction();
		System.out.println("============================================================================");
		fractionToDecimal();
		mat.printPrimeNumbers();
		System.out.println("============================================================================");
		//distance between two lat/longs
		mat.distBetTwoPointsInEarth();
		System.out.println("============================================================================");
		mat.toHexadecimal();
		System.out.println("============================================================================");
		mat.toOctadecimal();
		System.out.println("============================================================================");
		//-------------bin dec hexdec, octadec
		mat.toDecimal();
		System.out.println("============================================================================");
		mat.toDecimal1();
		System.out.println("============================================================================");
		mat.toBinary();
		System.out.println("============================================================================");
		mat.addBinary();
		System.out.println("============================================================================");
		mat.areaAndPerimeterCircle();
		System.out.println("============================================================================");
		mat.areaAndPerimeterRectangle();
		System.out.println("============================================================================");
		mat.evaluate1();
		System.out.println("============================================================================");
		mat.display8x1();
		System.out.println("============================================================================");
		mat.product();
		System.out.println("============================================================================");
		mat.reverseNum();
		System.out.println("============================================================================");
		mat.findVal();
		System.out.println("============================================================================");
		mat.doubleTillMonth();
		System.out.println("============================================================================");
		mat.sumOfDistinctNum();
		System.out.println("============================================================================");
	}

	public void sortIntArr() {
		
		int[] arr = {3,4,5,4,5,7,9,3,1,7};

		int arrLen = arr.length;

		int[] tempArr = new int[10];

		//displayArr(tempArr);
		
		System.out.println("Initial arr");
		displayArr(arr);

		int k= 0, temp =0;
		for(int i = 0; i< arrLen; i++){
			
			for(int j = i+1;j<arrLen;j++) {
				if(arr[i]>arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
			
		}
		System.out.println("Sorted arr");
		displayArr(arr);
		
		for(int i = 0; i< arrLen; i++){
			
			if(i==arrLen-1) {
				tempArr[k] = arr[i];
				break;
			}
			if(arr[i] != arr[i+1]) {
				tempArr[k++] = arr[i];
			}
		}
		
		System.out.println("Unique tempArr");
		displayArr(tempArr);
			
	}
	
	public void removduplicateinArr() {
		
		int[] arr = {3,4,5,4,5,7,9,3,1,7};

		int arrLen = arr.length;
		
		int[] tempArr = new int[10];
		
		System.out.println("Initial arr");
		displayArr(arr);

		int k= 0;
		for(int i = 0; i< arrLen; i++){
			boolean duplicate = false;
		
			for(int j = 0;j<arrLen;j++) {
				if(arr[i] == tempArr[j]) {
					duplicate = true;
					k++;
					break;
				}
			}
			
			if(!duplicate) {
				tempArr[i-k] = arr[i];
			}
		}
		System.out.println("Processed tempArr");
		displayArr(tempArr);
		
	}
	
	public void uniqueIntArr() {
		
		int[] arr = {3,4,5,4,5,7,9,3,1,7};

		int arrLen = arr.length;

		int[] tempArr = new int[10];
		
		System.out.println("Initial arr");
		displayArr(arr);
		//WRITE LOGIC
		LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
		
		for (int i = 0; i < arrLen; i++) {
			lhs.add(arr[i]);
		}
		
		System.out.println("Unique tempArr");
		System.out.println(lhs);
			
	}
	public void missingInteger() {
		/*
		 * Given an array arr[] of size N-1 with integers in the range of [1, N], the
		 * task is to find the missing number from the first N integers. Input: arr[] =
		 * {1, 2, 4, 6, 3, 7, 8} Output: 5
		 */

		int[] arr = new int[] { 7, 6, 5, 3, 8, 9 };
		displayArr(arr);

		int[] arr1 = new int[5];
		displayArr(arr1);

		
		// sort the array { 3, 4, 5, 7, 8, 9};
		// arr[0] = starting number
		// arr[n-1] = end number
		int arrLen = arr.length;
		int k = 0, temp = 0;
		for (int i = 0; i < arrLen; i++) {

			for (int j = 0; j < arrLen; j++) {
				if (arr[i] < arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}

		}

		displayArr(arr);

		int startInt = arr[0];
		int endInt = arr[arr.length - 1];
		int j = 0;
		boolean isMissing = false;
		int missingNumber = 0;
		for (int i = startInt; i < endInt; i++) {

			if (i == arr[j]) {
				isMissing = false;
			} else {
				isMissing = true;
				missingNumber = i;
				break;
			}
			
			j++;
		}

		System.out.println("Misssing number :" + missingNumber);
	}

	public void missingNumber1() {

		int[] arr = new int[] { 1, 2, 4, 6, 3, 7, 8 };
		// 31,

		int sum = 0, sumN = 0;
		for (int i = 1; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("sum : " + sum);
		for (int i = 1; i <= arr.length + 1; i++) {
			sumN += i;
		}
		System.out.println("sumN : " + sumN);
		int missingNum = (sumN - sum);
		System.out.println("Missing number is:" + sumN + " - " + sum + " : " + missingNum);
	}

	public static void displayArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}

		System.out.println();
	}

	public void trailingZerosInFactorial() {
		int num = 15;

		System.out.println("Number is :"+ num);
		long factorial = 1;

		for (int i = 1; i <= num; i++) {
			factorial *= i;
		}

		int trailZeros = 0;
		long tempFacto = factorial;
		while (tempFacto > 0) {
			if (tempFacto % 10 == 0) {
				trailZeros++;
			} else {
				break;
			}
			tempFacto = tempFacto / 10;
		}

		System.out.println("Number of trailing zeros for " + num + " factorial(" + factorial + ") :" + trailZeros);
	}

	public void trailingZerosInFactorial1() {
		int n = 28;

		int trailZeros = 0;

		for (int i = 5; n/i >= 1; i *= 5) {
			trailZeros += n/i;
		}
		System.out.println("Number of trailing zeros for " + n + " factorial : is " + trailZeros);
		
	}

	public void simpleFraction() {
		/*
		 * Input: Numerator = 1, Denominator = 2 Output: "0.5" 1/2 = 0.5 with no
		 * repeating part.
		 * 
		 * Input: Numerator = 50, Denominator = 22 Output: "2.(27)" 50/22 =
		 * 2.27272727... Since fractional part (27) is repeating, it is enclosed in
		 * parentheses.
		 * 
		 */
		
		long Numerator = 50, Denominator = 22;
		
		String result = Numerator/Denominator +"";
		
		System.out.println(result + "  --> "+ Math.floorDiv(Numerator, Denominator));

		/*
		String[] strNum = result.split("[.]");
		System.out.println("Output: "+strNum[0]+".("+strNum[1].substring(0, 2)+")");
		*/
		
	}
	
	static void fractionToDecimal()
    {
		int numr =50, denr = 4;
        // Initialize result
        String res = "";
 
        // Create a map to store already
        // seen remainders. Remainder is
        // used as key and its position in
        // result is stored as value.
       // Note that we need position for
        // cases like 1/6.  In this case,
        // the recurring sequence doesn't
        // start from first remainder.
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        mp.clear();
 
        // Find first remainder
        int rem = numr % denr;
 
        // Keep finding remainder until
        //  either remainder becomes 0 or repeats
        while ((rem != 0) && (!mp.containsKey(rem))) 
        {
            // Store this remainder
            mp.put(rem, res.length());
 
            // Multiply remainder with 10
            rem = rem * 10;
 
            // Append rem / denr to result
            int res_part = rem / denr;
            res += String.valueOf(res_part);
 
            // Update remainder
            rem = rem % denr;
        }
 
        if (rem == 0)
            System.out.println("none");
        else if (mp.containsKey(rem))
        	System.out.println(""+res.substring(mp.get(rem)));
 
    }
	public void printPrimeNumbers() {
		int sumPrime = 0, primeNumCount =0, lastPrimeNum = 0;
		for (int i = 1; i < 1000; i++) {
			
			if(primeNumCount==100) {
				lastPrimeNum = i;
				break;
			}
			if(checkForPrime(i)) {
				primeNumCount++;
				System.out.print(i+" ");
				sumPrime+=i;
			}
		}
		System.out.println();
		System.out.println("Last primeNumber : "+lastPrimeNum);
		System.out.println("Total sum of prime numbers :"+sumPrime);
	}

	public boolean isPrime(int n){
        if (n <= 1)
            return false;
 
        
        // Check if n=2 or n=3
        if (n == 2 || n == 3)
            return true;
 
        // Check whether n is divisible by 2 or 3
        if (n % 2 == 0 || n % 3 == 0)
            return false;
 
        // Check from 5 to square root of n
        // Iterate i by (i+6)
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        
        /*
        for(int k=2;k<=9;k++) {
        	if(n%k==0) {
        		return false;
        	}
        }*/
        return true;
    }		
	
	static boolean checkForPrime(int inputNumber) {
		boolean isPrime = true;
		if (inputNumber <= 1) 
			return false;
			 
			for (int i = 2; i <= inputNumber/2; i++) {
				if ((inputNumber % i) == 0) {
					isPrime = false;
					break;
				}
			}
			return isPrime;
	}
	
	public void distBetTwoPointsInEarth() {
		double lat1 = Math.toRadians(25.735251);
		double long1 = Math.toRadians(-80.480141);
		
		double lat2 = Math.toRadians(25.705252);
		double long2 = Math.toRadians(-80.460142);
		
		System.out.println(lat1 +", "+long1 +"   "+lat2+", "+long2);
		double earthRadius = 6371.01;
		
		// Distance = r * acos(sin(x1)*sin(x2) + cos(x1)*cos(x2)*cos(y1-y2));
		double Distance = earthRadius * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1-long2));
		
		System.out.println("Distance between two points : "+Distance);
		
	}
	
	public void toHexadecimal() {
		int decimal = 1258, temp = decimal, rem = 0, val = 0;
		String hexD = "";
		String hexaDec = Integer.toHexString(decimal);
		System.out.println("Integer "+temp+" in HexaDecimal is "+hexaDec);
		char[] hexArr = new char[] {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		while(decimal > 0) {
			rem = decimal%16;
			hexD = hexArr[rem]+hexD;
			decimal /= 16;
		}
		
		System.out.println("Integer "+temp+" in HexaDecimal is "+hexD);
	}
	
	public void toOctadecimal() {
		int decimal = 15, temp = decimal, rem = 0, val = 0;
		String octD = "";
		String octDec = Integer.toOctalString(decimal);
		System.out.println("Integer "+temp+" in OctaDecimal is "+octDec);
		
		
		while(decimal > 0) {
			rem = decimal%8;
			octD = rem+octD;
			decimal /= 8;
		}
		
		System.out.println("Integer "+temp+" in OctaDecimal is "+octD);
	}
	
	public void toDecimal() {
		
		int i = 0, decimal = 0;
		long bin = 101111, temp = bin;
		int binLenght = Long.toString(bin).length();
		System.out.println(binLenght);
		int[] binArray = new int[binLenght];
		while(bin > 0) {
			binArray[i++] = (int) (bin%10);
			bin/=10;
		}
		System.out.println("binary values "+ binArray);
		for (int j = binArray.length-1; j >= 0; j--) {
			System.out.print(" "+binArray[j]);
		}
		
		for (int j = 0; j < binArray.length; j++) {
			decimal = (int) (decimal + binArray[j] * Math.pow(2, j));
		}
		
		System.out.println();
		System.out.println("Binary "+temp+" in Decimal is "+decimal);
	}

	public void toDecimal1() {
		int num = 101111;
		int ans = 0, rem = 0, temp = num;
        int i = 0;
        while (num > 0) {
 
            // remainder when num is
            // divided by 10
            rem = num % 10;
 
            // quotient
            num /= 10;
 
            // Calculating decimal number
            ans += rem * Math.pow(2, i);
            i++;
        }
        System.out.println("Binary "+temp+" in Decimal is "+ans);
	}
	
	public void toBinary() {
		int x = 47, rem = 0, temp =x;
		String binary = Integer.toBinaryString(x);
		
		System.out.println("Integer "+x+" in Binary is "+binary);
		String binStr = "";
		while(x > 0) {
			rem = x%2;
			x = x/2;
			binStr = rem + binStr;
		}
		System.out.println("Integer "+temp+" in Binary is "+binStr);
	}
	
	
	public void addBinary() {
		
		long bin1, bin2;
		
		int i=0, rem = 0;
		
		int[] sum = new int[20];
		
		bin1 = 1001;
		bin2 = 101;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter first binary number :"+bin1);
		//bin1 = in.nextLong();
		
		System.out.println("Enter second binary number :"+bin2);
		//bin2 = in.nextLong();
		
		long exp = 0;
		while(bin1>0 || bin2>0) {
			
			exp = bin1%10 + bin2%10 + rem;
			sum[i++] = (int) (exp%2);
			rem = (int) (exp/2);
			bin1/=10;
			bin2/=10;
		}
		
		if(rem != 0) {
			sum[i] = rem;
		}
		
		System.out.print("Sum of two binary numbers: ");
		  while (i >= 0) {
		   System.out.print(sum[i--]);
		  }
		 System.out.println();
	}
	
	public void areaAndPerimeterCircle() {
		double pi = Math.PI;
		//Area = pi * r * r
		//Perimeter = 2 * pi * r
		double r = 7.5;
		System.out.println("Pi Value = "+pi);
		System.out.println("Area of circle = "+ pi * r * r);
		System.out.println("Perimeter of circle = "+ 2 * pi * r);
		
	}
	
	public void areaAndPerimeterRectangle() {
		
		//Area = l * b
		//Perimeter = 2 * (l + b)
		double l = 5.6;
		double b = 8.5;
		//System.out.println("Pi Value = "+pi);
		System.out.println("Area of Rectangle = "+ l * b);
		System.out.println("Perimeter of Rectangle = "+ 2 * (l + b));
		
	}

	public void evaluate1() {
		//((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5))
		
		//double d = ((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5));
		double d = ((25 * 3 - 3 * 3) / (40 - 4));
		double d1 = 4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11));
		
		System.out.println(d);
		System.out.println(d1);
	}
	
	public void display8x1() {
		
		for(int i=1;i<=10; i++) {
			System.out.println("8 X "+i +" = "+ (8 * i));
		}
	}
	public void product() {
		
		Scanner in  = new Scanner(System.in);
		
		System.out.println("Enter first number: ");
		//int i = in.nextInt();
		int i = 10; //  1010

		System.out.println("Enter second number: ");
		//int j = in.nextInt();
		int j = 12; //  1100
		
		int result = i * j;
		
		System.out.println("Product is : "+result);
		
		System.out.println("(i | j) : "+ (i | j)); 
		//  1010
		//  1100
		//--------
		//  1110 
		System.out.println("(i & j) : "+ (i & j));
		//  1010
		//  1100
		//--------
		//  1000
		
		System.out.println("Enter String: ");

		String str = "Hi";
		System.out.println("Entered Text is : "+str);
		
	}
	
	public void reverseNum() {
		int num = 3568;
		int temp = num;
		int rem = 0, revNum = 0;
		while(num > 0) {
			rem = num%10;
			
			num = num/10;
			System.out.println(num);
			revNum = revNum*10 + rem;
		}
		System.out.println("Reverse num of "+temp+" is "+revNum);
	}
	
	public void findVal() {
		int x= 10;
		System.out.println("x value :" +x++);
		System.out.println("x value :" +x);
		System.out.println("x value :" + ++x+x++);
		
		
	}
	
	public void doubleTillMonth() {
		
		int sum = 1;
		for (int i = 1; i <= 30; i++) {
			System.out.println("Amount doubled on day "+(i)+" :"+sum);
			sum += sum;
			
		}
		System.out.println("Amount with doubled every day for a month :"+sum);
	}
	
	public void sumOfDistinctNum() {
	int[] arr = {5,1,8,4,9,1,5};
	//HashSet<Integer> hs = new HashSet<Integer>();
	int sum = 0;
	String temp = "";
		for(int i=0;i<arr.length;i++){
			//if(!temp.contains(arr[i]+"")) {
			if(!temp.contains(String.valueOf(arr[i]))) {
				temp+=arr[i]+",";
			}
		}
		
		String[] values = temp.split(",");
		
		for (String str: values) {
			sum += Integer.parseInt(str);
		}
		
		System.out.println("Sum of unique numbers in array :"+sum);
    }
	
}
