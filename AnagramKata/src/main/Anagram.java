package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;
 
public class Anagram
{
   private HashMap<String, TreeSet<String>> anagrams = new HashMap<String, TreeSet<String>>();
   
   private void loadFile(String filePath) {
     try {
       BufferedReader br = new BufferedReader(new FileReader(filePath));
       String word;
       while ((word = br.readLine()) != null)
       {
         getListByKey(anagrams, getSortedWord(word)).add(word);
       }
     }
     catch (FileNotFoundException e) {
       //e.printStackTrace();
       System.out.println(e.getMessage());
     }
     catch (IOException e) {
       //e.printStackTrace();
       System.out.println(e.getMessage());       
     }
  }

 //returns the list in the hashmap with the specified key or created if it doesn't exists
	private TreeSet<String> getListByKey(HashMap<String, TreeSet<String>> hashMap, String key) {
	     
	     if (!hashMap.containsKey(key)) {
	    	 TreeSet<String> result = new TreeSet<String>();
	       hashMap.put(key, result);
	     }
	      return hashMap.get(key);
	}

	public void findAnagrams(String input, String output){
		this.loadFile(input);
	    this.saveResult(output);
	}
	
	private String getSortedWord(String word){
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars).toLowerCase();
	}
	
	public String listToString(TreeSet<String> list){
		String result = "";
		for (String s : list){
			result += s + " ";
		}
	//System.out.println(result);
		return result;
	}

	private void saveResult (String output){
		File file = new File(output);
		try {
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (String anagrams : getSortedList()){
				bw.write(anagrams);
				bw.newLine();
			}
			
			bw.close();
		
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private TreeSet<String> getSortedList(){
		TreeSet<String> result = new TreeSet<String>();
		for (TreeSet<String> list : anagrams.values()){
			result.add(listToString(list));
		}
		return result;
	}

}

