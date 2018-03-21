package com.languageanalyser;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

public class Sentence
{
	
	public ArrayList<String> sentence;
	
	public String line;
	public BreakIterator iterator;
	public String part1;
	public String part2;
	public static String joinHolder = "";   //used to store end of line but not end of sentence
	
	
	public Sentence(String line)
	{
		this.line = line;
		
		
		if (line.endsWith("."))
		{
			String[] sSentence = line.split("(?<=[a-z])\\.\\s+");
			
			for (String sentence : sSentence) 
			{
				
				if(Character.isLowerCase(sentence.codePointAt(0))) 
				{
					sentence = String.join(" ",joinHolder, sentence);
				}
								
				System.out.println(sentence);
				
			}		
			
		}
		else
		{
			String[] sSentence = line.split("(?<=[a-z])\\.\\s+");
			
			int last = sSentence.length - 1;
			
			joinHolder = sSentence[last];
			sSentence[last] = " ";
			
			for (String sentence : sSentence) 
			{
				
				if (sentence != " ") 
				{
					System.out.println(sentence);	
				}
				
			}
		}
		
			
	}
	
}
