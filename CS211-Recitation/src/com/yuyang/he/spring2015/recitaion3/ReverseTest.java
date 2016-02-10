package com.yuyang.he.spring2015.recitaion3;

/**
 * @author YuyangHE
 * @date 2016Äê2ÔÂ6ÈÕ
 * @version 1.0
 * @since
 */
public class ReverseTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		DoublyLinkedList<Integer> n1 = new DoublyLinkedList<Integer>(1);
		n1.addANode(2);
		n1.addANode(3);
		n1.addANode(4);
		n1.addANode(5);
		n1.addANode(6);
		n1.addANode(7);
		System.out.println(n1);
		System.out.println(n1.reverse(n1));
	}

}
