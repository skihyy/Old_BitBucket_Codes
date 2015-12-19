package com.yuyang.he.Roman2Integer;

/**
 * @author Yuyang He
 * @date Nov 29, 2015
 * @version 1.0
 * @since
 */
public class Roman2Integer
{

	/**
	 * Given a roman numeral, convert it to an integer. Input is guaranteed to
	 * be within the range from 1 to 3999.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(isPowerOfTwo(5));
	}
	
	public static boolean isPowerOfTwo(int n) {
        if(n == 0)
        {
            return true;
        }
        
        int m = n;
        while(true)
        {
            if(2 == m)
            {
                return true;
            }
            
            m = m >> 1;
            
            if(m > n || 0 == m)
            {
                return false;
            }
        }
    }

}
