package com.languageanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Word 
{
	public String sentence;
	public String[] words;
	public static float noOfLetters, avgWordLength, badWords;
	File badWordsFile = new File("badLanguage.txt");
	Scanner sc = null;
	
	
	public Word(String sentence)
	{
		
		try 
		{
			sc = new Scanner(badWordsFile);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		this.sentence = sentence;
		
		words = sentence.split(" ");
		
		for (String word : words)
		{
			
				
			noOfLetters += word.length();
			badLanguage(word);
			
			System.out.println(word);
			
				
			
		}
		
		avgWordLength = noOfLetters/Line.noOfWords;
		
		
	}
	
	public void badLanguage(String word)
	{
		//****** not iterating through lines
		while(sc.hasNextLine())
		{
			for(int i = 0; sc.hasNext() != false; i++)
			{
				
				if(word.equals(sc.nextLine().trim()))
				{
					badWords++;
					break;
				}
				else
				{
					break;
				}
			}
			
		}
	}

}
