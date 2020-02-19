package com.fun.programs.simple;

public class AnagramWithoutExtraSpace

{
	private static int counter=1;
	public static void main(String[] args)
	{
		char[] input = { 'a', 'b', 'c', 'd' };
		createAnagram(input, 0);
	}

	private static void createAnagram(char[] input, int startIndex)
	{
		if (startIndex == input.length-1)
		{
			System.out.println(counter++);
			System.out.println(input);
			return;
		}
		//a b c
		for (int i = startIndex; i < input.length ; i++)
		{
			swap(input, startIndex, i);
			createAnagram(input, startIndex + 1);
			swap(input, startIndex, i);
		}
	}

	private static void swap(char[] input, int startIndex, int endIndex)
	{
		if (startIndex < 0 || endIndex > input.length)
		{
			throw new RuntimeException("Failing Condition: startIndex<0 && endIndex>input.length");
		}
		char temp = input[endIndex];
		input[endIndex] = input[startIndex];
		input[startIndex] = temp;
	}
}
