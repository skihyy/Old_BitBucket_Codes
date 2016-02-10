package com.yuyang.he.spring2015.recitaion2;

/**
 * @author YuyangHE
 * @date 2016Äê2ÔÂ1ÈÕ
 * @version 1.0
 * @param <T>
 * @since
 */
public interface BasicNodeObject<T>
{
	/**
	 * Add a new element in to the list.
	 * 
	 * @param <T>
	 * @param head
	 *            the head of the list
	 * @param data
	 *            the data to be added
	 */
	void addNewElement(NodeObject<T> head, T data);

	/**
	 * A method that will add a new integer before the last value in the linked
	 * list whose first node is pointed to by front. (In other words, the added
	 * integer will become the second-to-last item in the resulting linked
	 * list.)
	 * 
	 * @param head
	 *            first node
	 * @param data
	 *            the new data to be added
	 * @return The method should return a pointer/reference to the front node of
	 *         the resulting linked list. If the input linked list is empty, the
	 *         method should return null, without doing anything.
	 */
	NodeObject<T> addBeforeLast(NodeObject<T> head, T data);

	/**
	 * A method that will search a given linked list for a target string, and
	 * return the number of occurrences of the target.
	 * 
	 * @param head
	 *            first node
	 * @param target
	 *            target to be searched
	 * @return the number of occurrences of the target
	 */
	int numberOfOccurrences(NodeObject<T> head, T target);

	/**
	 * A method to delete EVERY OTHER item from an integer linked list.
	 * 
	 * @param head
	 *            first node
	 */
	void deleteEveryOther(NodeObject<T> head);

	/**
	 * A method that will delete all occurrences of a given target string from a
	 * linked list, and return a pointer to the first node of the resulting
	 * linked list.
	 * 
	 * @param head
	 *            first node
	 * @param target
	 *            target to be searched
	 */
	NodeObject<T> deleteAllOccurrences(NodeObject<T> head, T target);
}
