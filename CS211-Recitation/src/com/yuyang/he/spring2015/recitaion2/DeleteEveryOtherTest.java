package com.yuyang.he.spring2015.recitaion2;

/**
 * @author YuyangHE
 * @date 2016Äê2ÔÂ1ÈÕ
 * @version 1.0
 * @since
 */
public class DeleteEveryOtherTest
{
	/**
	 * For example: before: 3->9->12->15->21 after: 3->12->21
	 * before: 3->9->12->15 after: 3->12
	 * before: 3->9 after: 3
	 * before: 3 after: 3
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		IntNode l1 = new IntNode(3);
		l1.addNewElement(l1, 9);
		l1.addNewElement(l1, 12);
		l1.addNewElement(l1, 15);
		l1.addNewElement(l1, 21);
		
		System.out.println("Before:");
		System.out.println(l1);

		System.out.println("1:");
		l1.deleteEveryOther(l1);
		System.out.println(l1);
		
		System.out.println("2:");
		l1.deleteEveryOther(l1);
		System.out.println(l1);
		
		System.out.println("3:");
		l1.deleteEveryOther(l1);
		System.out.println(l1);
		
		System.out.println("4:");
		l1.deleteEveryOther(l1);
		System.out.println(l1);
		
		
	}
}
