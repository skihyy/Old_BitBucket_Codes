package util;

import structures.Node;

/**
 * @author YuyangHE
 * @date 2016��2��7��
 * @version 1.0
 * @since
 */
public class NodeUtil
{
	public static <T> int countLength(Node<T> front)
	{
		int length = 0;
		Node<T> tmp;
		T frontData = null;
		
		if(null != front)
		{
			length = 1;
			tmp = front;
			frontData = front.getData();
			
			while(null != tmp)
			{
				if(frontData == tmp.getData())
				{
					break;
				}
				++length;
				tmp = tmp.getNext();
			}
		}
		
		return length;
	}
}
