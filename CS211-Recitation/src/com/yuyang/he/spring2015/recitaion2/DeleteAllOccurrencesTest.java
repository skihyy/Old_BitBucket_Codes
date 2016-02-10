package com.yuyang.he.spring2015.recitaion2;

/**
 * @author YuyangHE
 * @date 2016Äê2ÔÂ1ÈÕ
 * @version 1.0
 * @since
 */
public class DeleteAllOccurrencesTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		NodeObject<Integer> l1 = new IntNode(3);
		l1.addNewElement(l1, 9);
		l1.addNewElement(l1, 12);
		l1.addNewElement(l1, 15);
		l1.addNewElement(l1, 21);
		l1.addNewElement(l1, 9);
		l1.addNewElement(l1, 12);
		l1.addNewElement(l1, 15);
		l1.addNewElement(l1, 9);
		l1.addNewElement(l1, 21);
		l1.addNewElement(l1, 9);
		
		System.out.println(l1);
		System.out.println("Delete 15:");
		l1 = l1.deleteAllOccurrences(l1, 15);
		System.out.println(l1);
		
		System.out.println("Delete 9:");
		l1 = l1.deleteAllOccurrences(l1, 9);
		System.out.println(l1);
		
		System.out.println("Delete 21:");
		l1 =  l1.deleteAllOccurrences(l1, 21);
		System.out.println(l1);
	}

}
