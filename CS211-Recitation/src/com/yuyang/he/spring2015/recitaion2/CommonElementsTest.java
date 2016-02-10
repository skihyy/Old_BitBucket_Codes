package com.yuyang.he.spring2015.recitaion2;

/**
 * @author YuyangHE
 * @date 2016Äê2ÔÂ1ÈÕ
 * @version 1.0
 * @since
 */
public class CommonElementsTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		IntNode l1 = new IntNode(3), l2 = new IntNode(2);
		l1.addNewElement(l1, 9);
		l1.addNewElement(l1, 12);
		l1.addNewElement(l1, 15);
		l1.addNewElement(l1, 21);
		
		l2.addNewElement(l2, 3);
		l2.addNewElement(l2, 6);
		l2.addNewElement(l2, 12);
		l2.addNewElement(l2, 19);
		
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l1.commonElements(l1, l2));

	}
}
