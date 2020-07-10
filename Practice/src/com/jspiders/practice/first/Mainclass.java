package com.jspiders.practice.first;

import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) {
		
		int num;
		Scanner sc = null;
		sc = new Scanner(System.in);
		System.out.print("Enter the value of Num : ");
		num = sc.nextInt();
		System.out.println("Num = "+num);
		if(sc!=null)
		{
			sc.close();
		}
		// 100 - lines of code
	}

}
