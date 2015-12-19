package com.yuyang.he.ValidAnagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * @author Yuyang He
 * @date Nov 27, 2015
 * @version 1.0
 * @since
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = count(s), tMap = count(t);
        
        if(sMap.size() != tMap.size())
        {
            return false;
        }
        
        Set<Character> set = sMap.keySet();
        for(char key : set)
        {
            if(!tMap.containsKey(key))
            {
                return false;
            }
            
            if(sMap.get(key) != tMap.get(key))
            {
                return false;
            }
        }
        
        return true;
    }
    
    private Map<Character, Integer> count(String s)
    {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        char[] cc = s.toCharArray();
        int count = 0;
        
        for(char c : cc)
        {
            if(map.containsKey(c))
            {
                count = map.get(c) + 1;
                map.put(c,count);
            }
            else
            {
                map.put(c,1);
            }
        }
        
        return map;
    }
}