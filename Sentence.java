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


import java.io.IOException;
import java.util.ArrayList; 

public class Sentence
{
	public ArrayList<String> sentence;
	private String line;
	private int last;
	public String part1;
	public String part2;
	private static String joinHolder = "";   //used to store end of line but not end of sentence
	private static float noOfSentences;
	
	
	public Sentence(String line) throws IOException
	{
		this.line = line;
		
		if (line.endsWith("."))
		{
			String[] sSentence = line.split("(?<=[a-z])\\.\\s+");
			//Line is split into sentences stored in sSentence
			
			for (String sentence : sSentence) 
			{
				
				//if first letter of sentence is lower case then is is continued from previous line
				if(Character.isLowerCase(sentence.codePointAt(0))) 
				{
					//Join unfinished sentence from previous line with first sentence in new line 
					sentence = String.join(" ",joinHolder, sentence);
				}
				
				//System.out.println(sentence);
				sentenceCount();
				
				Word word = new Word(sentence);
			}		
		}
		else
		{
			String[] sSentence = line.split("(?<=[a-z])\\.\\s+");
			
			if(sSentence.length > 1)
			{
				last = sSentence.length - 1;
				
				joinHolder = sSentence[last];
				sSentence[last] = " ";
			}
			else
			{
				last = 0;
				joinHolder = sSentence[last];
			}
			
			
			for (String sentence : sSentence) 
			{
				if (sentence != " ") 
				{
					//System.out.println(sentence);	
					sentenceCount();
				}
				Word word = new Word(sentence);
			}
		}
	}
	
	public void sentenceCount()
	{
		noOfSentences++;
	}

	public static float getNoOfSentences() {
		return noOfSentences;
	}

	public static void setNoOfSentences(float noOfSentences) {
		Sentence.noOfSentences = noOfSentences;
	}
	
	
	
	
}
