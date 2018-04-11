package com.languageanalyser;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Word 
{
	public String sentence;
	public String[] words;
	public static boolean formal;
	public static float noOfLetters, avgWordLength, badWords;
	public Path badLangPath;
	private Charset charset;
	private List<String> badLangList;
	private String[] badLangArr;
	
	
	
	public Word(String sentence) throws IOException
	{
			
		this.sentence = sentence;
		
		words = sentence.split(" ");
		
		for (String word : words)
		{
			noOfLetters += word.length();
			badLanguage(word);
			formal(word);
			
			System.out.println(word);			
		}
		
		avgWordLength = noOfLetters/Line.noOfWords;
	}
	
	
	public void badLanguage(String word) throws IOException
	{
		//Checks if word is in badLanguge file
		badLangPath = new File("badLanguage.txt").toPath();
		charset = Charset.defaultCharset();
		badLangList = Files.readAllLines(badLangPath, charset);
		word = word.toLowerCase();
		
		
		for(String badWord : badLangList) 
		{
			if(word.equals(badWord))
			{
				badWords++;
			}
		
		}
		
		
	}
	
	
	public void formal(String word)
	{
		String[] formalWords = {"dear", "sir", "madam", "mr", "mrs", "whom"};
		word = word.toLowerCase();
				
		for(int i =0; i < formalWords.length; i++)
		{
	        if (Arrays.asList(formalWords).contains(word)) 
	        {
	        	formal = true;
	        }
		}
	        	
	}
	
	

}
