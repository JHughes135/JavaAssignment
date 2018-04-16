/*

Java Assignment 2nd Year

Program description: This program receives text from a text file and determines whether the text uses formal
or informal language. It works by looking at the amount of formal and informal words used and also some 
elements of grammar.

OS: Windows 10
Date: 16/04/2018
James Hughes

*/
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
	public static float noOfLetters, avgWordLength, badWords, formalWords;
	private Path badLangPath, formalLangPath;
	private Charset charset;
	private List<String> badLangList, formalLangList;	
	
	
	public Word(String sentence) throws IOException
	{
			
		this.sentence = sentence;
		
		words = sentence.split(" ");
		
		for (String word : words)
		{
			word.replace(",", "");
			word.replace(".", "");
			noOfLetters += word.length();
			badLanguage(word);
			formal(word);
			
			System.out.println(word);			
		}
		
		avgWordLength = noOfLetters/Line.getNoOfWords();
	}
	
	
	public void badLanguage(String word) throws IOException
	{
		//Checks if word is in badLanguge.txt file
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
	


	public void formal(String word) throws IOException
	{
		//Checks if word is in fromalLanguge.txt file
		formalLangPath = new File("formalLanguage.txt").toPath();
		charset = Charset.defaultCharset();
		formalLangList = Files.readAllLines(formalLangPath, charset);
		word = word.toLowerCase();
				
		for(String formalWord : formalLangList) 
		{
			if(word.equals(formalWord))
			{
				formalWords++;
			}
		} 	
	}
	
	
	
	public static float getNoOfLetters() {
		return noOfLetters;
	}


	public static void setNoOfLetters(float noOfLetters) {
		Word.noOfLetters = noOfLetters;
	}


	public static float getAvgWordLength() {
		return avgWordLength;
	}


	public static void setAvgWordLength(float avgWordLength) {
		Word.avgWordLength = avgWordLength;
	}


	public static float getBadWords() {
		return badWords;
	}


	public static void setBadWords(float badWords) {
		Word.badWords = badWords;
	}


	public static float getFormalWords() {
		return formalWords;
	}


	public static void setFormalWords(float formalWords) {
		Word.formalWords = formalWords;
	}
	
	

}
