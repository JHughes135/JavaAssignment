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

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

import org.apache.commons.lang3.*;



public class Line 
{
	
	private JFileChooser fc = new JFileChooser("C:\\Users\\hughe\\OneDrive\\Documents\\College\\2nd Year\\Object Orientated programming\\Java\\Assignment\\LanguageAnalyser");
	private File inFile;
	BufferedReader br = null;
	FileReader fr = null;
	private static int noOfLines;
	private static int fullStopCount, upperCaseCount;
	private static float noOfWords;
	
	
	public String line;

	
	//This class reads raw lines from the file and checks punctuation, counts words, lines, fullstops and uppercase letters
	public Line() 
	{
		fc.setDialogTitle("Analyser");
		if(fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) 
		{
				analyseControl();	
		}
	}
	

	private void analyseControl() 
	{
		/*Used to store file variable of input file
		 * received from fileChooser
		 */
		inFile = fc.getSelectedFile();
		
		try 
		{
			fr = new FileReader(inFile);
			br = new BufferedReader(fr);
			
			//While the file has next line
			while ((line = br.readLine()) != null)
			{		
				lineCount();
				fullStopCount();
				upperCase();
				
				//adds wordCount of line to overall file wordcount
				noOfWords += countWords(line);
				
				//Creates a sentence object to split line into sentences and process it
				Sentence sent = new Sentence(line);				
			}			
		} 
		catch (FileNotFoundException e1) 
			{
				System.out.println("Error");
				
			} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void lineCount()
	{
		noOfLines ++;
	}
	
	//Method to count full stops in line
	public void fullStopCount() 
	{
		fullStopCount += StringUtils.countMatches(line, ".");
	}
	
	//Method to count uppercase letters in line
	public void upperCase()
	{
		for (char letter : line.toCharArray())
		{
			if (Character.isUpperCase(letter))
			{
				upperCaseCount++;
			}
		}
	}
	
	//****** REF This code is taken from https://stackoverflow.com/questions/5864159/count-words-in-a-string-method ******
	public static int countWords(String s){

	    int wordCount = 0;

	    boolean word = false;
	    int endOfLine = s.length() - 1;

	    for (int i = 0; i < s.length(); i++) {
	        // if the char is a letter, word = true.
	        if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
	            word = true;
	            // if char isn't a letter and there have been letters before,
	            // counter goes up.
	        } else if (!Character.isLetter(s.charAt(i)) && word) {
	            wordCount++;
	            word = false;
	            // last word of String; if it doesn't end with a non letter, it
	            // wouldn't count without this.
	        } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
	            wordCount++;
	        }
	    }
	    return wordCount;
	}
	
	//******** End of REF https://stackoverflow.com/questions/5864159/count-words-in-a-string-method *****


	
	//Getters and Setters 
	
	
	public static int getNoOfLines() {
		return noOfLines;
	}


	public static void setNoOfLines(int noOfLines) {
		Line.noOfLines = noOfLines;
	}


	public static int getFullStopCount() {
		return fullStopCount;
	}


	public static void setFullStopCount(int fullStopCount) {
		Line.fullStopCount = fullStopCount;
	}


	public static int getUpperCaseCount() {
		return upperCaseCount;
	}


	public static void setUpperCaseCount(int upperCaseCount) {
		Line.upperCaseCount = upperCaseCount;
	}


	public static float getNoOfWords() {
		return noOfWords;
	}


	public static void setNoOfWords(float noOfWords) {
		Line.noOfWords = noOfWords;
	}
	

	public String toString() 
	{
		return line ;
	}
	
	
	
}