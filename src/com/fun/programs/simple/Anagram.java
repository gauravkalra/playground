package com.fun.programs.simple;

import java.util.ArrayList;
import java.util.List;

public class Anagram
{

	public static void main(String[] args)
	{
		String str = "abc";
		List<String> anagrams = createAnagram(str);
		System.out.println(anagrams.size());
		for (String anagram : anagrams)
		{
			System.out.println(anagram);
		}
	}

	public static List<String> createAnagram(String str)
	{
		List<String> anagrams = new ArrayList<String>();
		if (str.length() == 2)
		{
			anagrams.add(str);
			anagrams.add(swap(str));
		}
		else
		{
			char[] characterArray = str.toCharArray();
			for (int i = 0; i < characterArray.length; i++)
			{
				String substring = substring(i, str);
				List<String> substringAnagrams = createAnagram(substring);
				for (String substringAnagram : substringAnagrams)
				{
					anagrams.add(characterArray[i] + substringAnagram);
				}
			}
		}
		return anagrams;
	}

	private static String swap(String str)
	{
		if (str.length() != 2)
		{
			throw new RuntimeException("Swap supported for only 2 char strings");
		}
		char[] array = str.toCharArray();
		return array[1] + "" + array[0] + "";
	}

	private static String substring(int index, String input)
	{
		if (index < 0 || index > input.length() - 1)
		{
			throw new RuntimeException("Failing condition: index<0 || index>input.length()-1");
		}
		String substring = "";
		if (index == 0)
		{
			substring = input.substring(index + 1, input.length());
		}
		else if (index == input.length() - 1)
		{
			substring = input.substring(0, input.length() - 1);
		}
		else
		{
			substring = input.substring(0, index) + input.substring(index + 1, input.length());
		}
		return substring;
	}

}
