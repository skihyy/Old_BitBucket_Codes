package com.yuyang.he.PowerOf2;

/**
 * @author YuyangHE
 * @date 2016Äê1ÔÂ22ÈÕ
 * @version 1.0
 * @since
 */
public class PowerOfTwo
{
	public static boolean isPowerOfTwo(int n)
	{
		if (0 < n)
		{
			double x = Math.log(n) / Math.log(3);
			System.out.println(x);
			if (n == Math.pow(3.0, ((int) x) * 1.0))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(isPowerOfTwo(243));
	}

}
