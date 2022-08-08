package com.aqm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class For {

	public static void main(String[] args) {
		
//			 Object  b[] =  new Object[]() ;

			List<Integer> r = new LinkedList<>();
			r.add(10);
			r.add(20);
			r.add(30);
			r.add(40);

			System.out.println(r);
			r.remove(3);
			System.out.println(r);
			r.set(2, 50);
			System.out.println(r);
			System.out.println(r.size());

			
	//arraylist
			for (int i = 0; i < r.size(); i++)
			{

				System.out.println("For " + r.get(i));
			}

			System.out.println("___________________________________________");

			
			for (Integer gt : r) {
				System.out.println("Foreach " + gt);
			}

			System.out.println("___________________________________________");

			Iterator<Integer> it = r.iterator();
			while (it.hasNext()) {
				System.out.println("Iterator " + it.next());

			}
			//Stack
			Stack<Integer> st = new Stack<>();
			st.push(20);
			st.push(30);
			st.push(40);
			st.push(50);
			st.push(60);

			System.out.println(st);
			System.out.println(st.peek());
			st.pop();
			System.out.println(st);
			for (Integer stt : st) {
				System.out.println("Stack Foreach " + stt);
			}
			
			System.out.println("______________________________________");
			System.out.println("______________________________________");

	//Queue
			Queue<Integer> qt = new LinkedList<>();
			qt.offer(100);
			qt.offer(1000);
			qt.offer(40);
			qt.offer(50);
			qt.offer(60);

			System.out.println(qt.poll());
			System.out.println(qt);
			System.out.println(qt.peek());

			for (Integer qtt : qt) {
				System.out.println("Queue Foreach " + qtt);

			}

			System.out.println("______________________________________");
			System.out.println("______________________________________");

			ArrayDeque<Integer> aqt = new ArrayDeque<>();
			aqt.offerLast(100);
			aqt.offer(1000);
			aqt.offerFirst(40);
			aqt.offer(50);
			aqt.offer(60);
			System.out.println(aqt);
			System.out.println(aqt.pollFirst());
			System.out.println(aqt.pollLast());
			System.out.println(aqt);
			
			System.out.println("______________________________________");
			System.out.println("______________________________________");

			// Type casting
			double i=210.321;
			int y= (int) i;
			System.out.println(""+i);
			System.out.println(""+y);
			System.out.println("______________________________________");
			System.out.println("______________________________________");

			
			Set<Integer> set= new TreeSet<Integer>();
			 
			set.add(10);
			set.add(20);
			set.add(30);
			set.add(40);
			set.add(50);
			set.add(1000);
			set.add(10);
			
			System.out.println(set);
			System.out.println(set.size());
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<");

			System.out.println(Collections.max(set));


			for(Integer sset :set) {
				System.out.println(""+sset);
				
			}
			
			System.out.println("______________________________________");
			System.out.println("______________________________________");
			
			Map<Integer, String> mp= new HashMap<Integer, String>();
			
			mp.put(1, "Asd");
			mp.put(2, "Rsd");
			mp.put(3, "Tsd");
			mp.put(4, "Ysd");
			mp.put(5, "Usd");
			
			System.out.println(mp);
			
			for(Integer rey: mp.keySet()) {
				System.out.println(rey);
			}

			for(String se: mp.values()) {
				System.out.println(se);
			}
			
			int a[] = {1,99,200,11,55,12819,76634,13242341};
			
			Arrays.sort(a);
		//	Arrays.fill(a, 113);;

			for(int o:a) {
			System.out.println(o);
			}
			   int arrayWithDuplicates[] = { 10, 3, 5, 3, 9, 22, 4, 3, 1, 5, 6 };  
			   
		        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();   
		            
		        for (int j = 0; j < arrayWithDuplicates.length; j++) {   
		            hashmap.put(arrayWithDuplicates[j], j);   
		        }      
		        System.out.println(hashmap.keySet());   
		    

		}
	}


