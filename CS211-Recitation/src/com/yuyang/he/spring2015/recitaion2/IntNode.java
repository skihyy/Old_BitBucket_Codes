package com.yuyang.he.spring2015.recitaion2;

/**
 * @author YuyangHE
 * @date 2016Äê2ÔÂ1ÈÕ
 * @version 1.0
 * @since
 */
public class IntNode extends NodeObject<Integer>
{

	/**
	 * Constructors of IntNode.
	 * 
	 * @param data
	 */
	public IntNode(Integer data)
	{
		super(data);
	}

	/**
	 * Constructors of IntNode.
	 * 
	 * @param data
	 * @param next
	 */
	public IntNode(Integer data, NodeObject<Integer> next)
	{
		super(data, next);
	}

	/**
	 * Creates a new linked list consisting of the items common to the input
	 * lists.
	 * 
	 * @param frontL1
	 *            linked list 1
	 * @param frontL2
	 *            linked list 2
	 * @return Returns the front of this new linked list, null if there are no
	 *         common items.
	 */
	public NodeObject<Integer> commonElements(IntNode frontL1, IntNode frontL2)
	{
		NodeObject<Integer> tmp1 = frontL1, tmp2 = frontL2, commonNodeHead = null, tmp = null;

		while (null != tmp1 && null != tmp2)
		{
			if (tmp1.data < tmp2.data)
			{
				tmp1 = tmp1.next;
			} else if (tmp1.data > tmp2.data)
			{
				tmp2 = tmp2.next;
			} else
			{
				if (null == commonNodeHead)
				{
					commonNodeHead = new IntNode(tmp1.data, null);
					tmp = commonNodeHead;
				} else
				{
					tmp.next = new IntNode(tmp1.data, null);
					tmp = tmp.next;
				}
				tmp1 = tmp1.next;
				tmp2 = tmp2.next;
			}
		}

		return commonNodeHead;
	}

}
