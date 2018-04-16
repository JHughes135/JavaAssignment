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


//This class takes the line object and splits it into sentences and counting them
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
			//Line is split into sentences stored in sSentence
			String[] sSentence = line.split("(?<=[a-z])\\.\\s+");
		
			
			for (String sentence : sSentence) 
			{
				
				//if first letter of sentence is lower case then it is continued from previous line
				if(Character.isLowerCase(sentence.codePointAt(0))) 
				{
					//Join unfinished sentence from previous line with first sentence in new line 
					sentence = String.join(" ",joinHolder, sentence);
				}
				
				//System.out.println(sentence);
				sentenceCount();
				
				//creates a word object using the sentence which splits the sentence into words and process them
				Word word = new Word(sentence);
			}		
		}
		else //if line does not end with full stop and sentence continues onto next line
		{
			//Line is split into sentences stored in sSentence
			String[] sSentence = line.split("(?<=[a-z])\\.\\s+");
			
			
			/*
			 * If line has more than one sentence in it
			 */
			if(sSentence.length > 1) 
			{
				//last part of the line that is split is stored in case sentence runs onto next line
				last = sSentence.length - 1;
				
				joinHolder = sSentence[last];
				sSentence[last] = " ";
			}
			else //if line consists of just one sentence
			{
				//The whole line is stored in case sentence runs onto next line
				last = 0;
				joinHolder = sSentence[last];
			}
			
			
			//counts sentences
			for (String sentence : sSentence) 
			{
				if (sentence != " ") //if line is not blank
				{
					//System.out.println(sentence);	
					sentenceCount();
				}
				
				//Creates word object to split sentence into words and process words
				Word word = new Word(sentence);
			}
		}
	}
	
	public void sentenceCount()
	{
		noOfSentences++;
	}

	
	//Getters and Setters 
	
	public static float getNoOfSentences() {
		return noOfSentences;
	}

	public static void setNoOfSentences(float noOfSentences) {
		Sentence.noOfSentences = noOfSentences;
	}
	
	
	
	
}
