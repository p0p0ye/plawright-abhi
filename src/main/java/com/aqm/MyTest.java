package com.aqm;

import java.util.Random;

public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random( );
		for(int i=0;i<10;i++)
	    System.out.println(((1 + r.nextInt(9)) * 100000 + r.nextInt(100000))+"");
	}

}
