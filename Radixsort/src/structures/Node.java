package structures;

public class Node<T>
{
	private T data;
	private Node<T> next;

	/**
	 * Constructors of Node.
	 * 
	 * @param data
	 * @param next
	 */
	public Node(T data, Node<T> next)
	{
		this.data = data;
		this.next = next;
	}

	/**
	 * Constructors of Node.
	 * 
	 * @param data
	 */
	public Node(T data)
	{
		this.data = data;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		Node<T> tmp = new Node<T>(this.data, this.next);
		T frontData = null;

		if (null != tmp)
		{
			frontData = tmp.getData();
			sb.append(frontData + "->");
			tmp = tmp.next;
		}

		while (null != tmp)
		{
			if (frontData == tmp.getData())
			{
				break;
			}
			sb.append(tmp.data + "->");
			tmp = tmp.getNext();
		}

		sb.append("null");

		return sb.toString();
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

	/**
	 * Getter of next.
	 * 
	 * @return the next
	 */
	public Node<T> getNext()
	{
		return next;
	}

	/**
	 * Setter of next.
	 * 
	 * @param next
	 *            the next to set
	 */
	public void setNext(Node<T> next)
	{
		this.next = next;
	}

}
