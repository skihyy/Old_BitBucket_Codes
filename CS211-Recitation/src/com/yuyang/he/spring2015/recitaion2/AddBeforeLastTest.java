package com.yuyang.he.spring2015.recitaion2;

/**
 * @author YuyangHE
 * @date 2016Äê2ÔÂ1ÈÕ
 * @version 1.0
 * @since
 */
public class AddBeforeLastTest
{
	public static void main(String [] args)
	{
		IntNode l1 = new IntNode(3), l2 = new IntNode(2), l3 = null, l4 = new IntNode(1);
		l1.addNewElement(l1, 9);
		l1.addNewElement(l1, 12);
		l1.addNewElement(l1, 15);
		l1.addNewElement(l1, 21);
		
		l4.addNewElement(l4, 7);
		
		System.out.println("Before:");
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println(l4);
		
		l1.addBeforeLast(l1, 88);
		l2.addBeforeLast(l2, 88);
		l1.addBeforeLast(l3, 88);
		l4.addBeforeLast(l4, 88);
		
		System.out.println();
		System.out.println("After:");
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println(l4);
		
		
	}
}
