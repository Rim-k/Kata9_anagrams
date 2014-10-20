package main;

import java.io.File;
import java.io.IOException;

public class Main
{
	public static void main(String[] args)
	{
		try {
			String dir = new File(".").getCanonicalPath();
				
			String input = dir + "\\words.txt";
		    String output = dir + "\\anagrams.txt";
			Anagram a = new Anagram();
			long startTime = System.nanoTime();
				a.findAnagrams(input, output);
			long endTime = System.nanoTime();
			System.out.println("Execution time: "+(endTime - startTime)/1000000 + " ms");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
