package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountDuplicates {
	static int countWords = 0;
	static String arList = new String();
	static int charCount = 0;
	static void countEachWords(String fileName, Map<String, Integer> words) throws FileNotFoundException {
		Scanner file = new Scanner(new File(fileName));
		while (file.hasNext()) {
           String word = file.next().toUpperCase();
           arList+=word;
			String rid = word.replaceAll("[^a-zA-Z0-9]", "");
			Integer count = words.get(rid);
			if (count != null)
				count++;
			else
				count = 1;
			if (!rid.equals("")) {
				words.put(rid, count);
				countWords++;
			}
			
		}
		file.close();
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Integer> words = new HashMap<String, Integer>();
		countEachWords("C:\\Users\\adam.varco\\Desktop\\test2.txt", words);
		for(Map.Entry<String, Integer> entry: words.entrySet()) {
			String oc = new String();
			if(entry.getValue()>1)
				oc = "occurrences";
			else
				oc= "occurrence";
			
			System.out.println(entry.getKey()+ " has " + entry.getValue() + " " +oc);
		}
		System.out.println("The total amount of words in the file is " + countWords);
		
		for(int i =0; i<arList.length(); i++) {
			charCount++;
		}
		System.out.println("Number of characters in the file is " +charCount);

	}

}
