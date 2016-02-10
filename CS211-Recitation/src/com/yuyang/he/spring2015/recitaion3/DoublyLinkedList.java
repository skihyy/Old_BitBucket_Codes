package com.yuyang.he.spring2015.recitaion3;

/**
 * @author YuyangHE
 * @date 2016Äê2ÔÂ6ÈÕ
 * @version 1.0
 * @since
 */
public class DoublyLinkedList<T>
{
	private T data;
	private DoublyLinkedList<T> next;
	private DoublyLinkedList<T> previous;

	/**
	 * Constructors of DoublyLinkedList.
	 * 
	 * @param data
	 */
	public DoublyLinkedList(T data)
	{
		this.setData(data);
		next = null;
		previous = null;
	}

	public void addANode(T data)
	{
		if (null == this.next)
		{
			this.next = new DoublyLinkedList<T>(data, null, this);
		} else
		{
			DoublyLinkedList<T> tmp = new DoublyLinkedList<T>(this.data, this.next, null);

			while (null != tmp.next)
			{
				tmp = tmp.next;
			}

			tmp.next = new DoublyLinkedList<T>(data, null, tmp);
		}
	}

	/**
	 * Getter of next.
	 * 
	 * @return the next
	 */
	public DoublyLinkedList<T> getNext()
	{
		return next;
	}

	/**
	 * Setter of next.
	 * 
	 * @param next
	 *            the next to set
	 */
	public void setNext(DoublyLinkedList<T> next)
	{
		this.next = next;
	}

	/**
	 * Getter of previous.
	 * 
	 * @return the previous
	 */
	public DoublyLinkedList<T> getPrevious()
	{
		return previous;
	}

	/**
	 * Setter of previous.
	 * 
	 * @param previous
	 *            the previous to set
	 */
	public void setPrevious(DoublyLinkedList<T> previous)
	{
		this.previous = previous;
	}

	/**
	 * Constructors of DoublyLinkedList.
	 * 
	 * @param data
	 * @param next
	 * @param previous
	 */
	public DoublyLinkedList(T data, DoublyLinkedList<T> next, DoublyLinkedList<T> previous)
	{
		this.setData(data);
		this.next = next;
		this.previous = previous;
	}

	/**
	 * A method to reverse the sequence of items in a DLL.
	 * 
	 * @param front
	 *            the front of the list
	 * @return the front of the resulting list.
	 */
	public DoublyLinkedList<T> reverse(DoublyLinkedList<T> front)
	{
		if (null == front || null == front.next)
		{
			return front;
		}

		front.previous = front.next;
		front.next = null;

		while (null != front.previous.next)
		{
			front.previous.previous = front.previous.next;
			front.previous.next = front;
			front = front.previous;
		}

		front = front.previous;
		front.next = front.previous;
		front.previous = null;

		return front;
	}

	/**
	 * Getter of data.
	 * 
	 * @return the data
	 */
	public T getData()
	{
		return data;
	}

	/**
	 * Setter of data.
	 * 
	 * @param data
	 *            the data to set
	 */
	public void setData(T data)
	{
		this.data = data;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		DoublyLinkedList<T> tmp = new DoublyLinkedList<T>(this.data, this.next, null);

		while (null != tmp)
		{
			sb.append(tmp.data + "->");
			tmp = tmp.next;
		}

		return sb.append("null").toString();
	}
}
