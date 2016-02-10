package com.yuyang.he.spring2015.recitaion2;

/**
 * @author YuyangHE
 * @date 2016Äê2ÔÂ1ÈÕ
 * @version 1.0
 * @since
 */
public class NodeObject<T> implements BasicNodeObject<T>
{
	/**
	 * data this node has
	 */
	protected T data;

	/**
	 * the next node object
	 */
	protected NodeObject<T> next;

	/**
	 * 
	 * Constructors of NodeObject.
	 * 
	 * @param data
	 */
	public NodeObject(T data)
	{
		this.data = data;
		this.next = null;
	}

	/**
	 * 
	 * Constructors of NodeObject.
	 * 
	 * @param data
	 * @param next
	 */
	public NodeObject(T data, NodeObject<T> next)
	{
		this.data = data;
		this.next = next;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		NodeObject<T> tmp = new NodeObject<T>(this.data, this.next);

		while (null != tmp)
		{
			sb.append(tmp.data + "->");
			tmp = tmp.next;
		}
		sb.append("null");
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yuyang.he.spring2015.recitaion2.BasicNodeObject#deleteAllOccurrences(
	 * com.yuyang.he.spring2015.recitaion2.NodeObject, java.lang.Object)
	 */
	@Override
	public NodeObject<T> deleteAllOccurrences(NodeObject<T> head, T target)
	{
		NodeObject<T> newHead = null, tmp = null;

		while (null != head)
		{
			if (target != head.data)
			{
				if (null == newHead)
				{
					newHead = new NodeObject<T>(head.data);
					tmp = newHead;
				} else
				{
					tmp.next = new NodeObject<T>(head.data);
					tmp = tmp.next;
				}
			}
			head = head.next;
		}

		return newHead;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yuyang.he.spring2015.recitaion2.BasicNodeObject#deleteEveryOther(com.
	 * yuyang.he.spring2015.recitaion2.NodeObject)
	 */
	@Override
	public void deleteEveryOther(NodeObject<T> head)
	{
		if (null == head)
		{
			return;
		}

		NodeObject<T> tmp = head;
		int count = 1;

		while (null != tmp.next)
		{
			if (1 == count % 2)
			{
				if (null != tmp.next.next)
				{
					tmp.next = tmp.next.next;
				} else
				{
					tmp.next = null;
				}
			} else
			{
				tmp = tmp.next;
			}
			++count;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yuyang.he.spring2015.recitaion2.BasicNodeObject#addNewElement(com.
	 * yuyang.he.spring2015.recitaion2.NodeObject, java.lang.Object)
	 */
	@Override
	public void addNewElement(NodeObject<T> head, T data)
	{
		if (null != head)
		{
			NodeObject<T> tmp = head;

			while (null != tmp.next)
			{
				tmp = tmp.next;
			}

			tmp.next = new NodeObject<T>(data);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yuyang.he.spring2015.recitaion2.BasicNodeObject#addBeforeLast(com.
	 * yuyang.he.spring2015.recitaion2.NodeObject, java.lang.Object)
	 */
	@Override
	public NodeObject<T> addBeforeLast(NodeObject<T> head, T data)
	{
		if (null == head)
		{
			return null;
		}

		NodeObject<T> newElement = new NodeObject<T>(data);

		if (null == head.next)
		{
			newElement.next = head;
			return newElement;
		}

		NodeObject<T> tmp = head;

		while (null != tmp.next.next)
		{
			tmp = tmp.next;
		}

		newElement.next = tmp.next;
		tmp.next = newElement;

		return head;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yuyang.he.spring2015.recitaion2.BasicNodeObject#numberOfOccurrences(
	 * com.yuyang.he.spring2015.recitaion2.NodeObject, java.lang.Object)
	 */
	@Override
	public int numberOfOccurrences(NodeObject<T> head, T target)
	{
		NodeObject<T> tmp = head;
		int occurences = 0;

		while (null != tmp)
		{
			if (target.equals(tmp.data))
			{
				++occurences;
			}
			tmp = tmp.next;
		}

		return occurences;
	}

}
