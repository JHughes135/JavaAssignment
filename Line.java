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
	public static int noOfLines;
	public static int fullStopCount, upperCaseCount;
	public static float noOfWords;
	
	
	public String line;

	public Line() 
	{
		fc.setDialogTitle("Analyser");
		if(fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) 
		{
				analyseControl();	
		}
	}
	

	public void analyseControl() 
	{
		inFile = fc.getSelectedFile();
		
		try 
		{
			fr = new FileReader(inFile);
			br = new BufferedReader(fr);
			
			while ((line = br.readLine()) != null)
			{		
				lineCount();
				fullStopCount();
				upperCase();
				noOfWords += countWords(line);
				
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
	
	
	public void fullStopCount() 
	{
		fullStopCount += StringUtils.countMatches(line, ".");
	}
	
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
	
	//******** End of REF https://stackoverflow.com/questions/5864159/count-words-in-a-string-method

	

	public String toString() 
	{
		return line ;
	}
	
	
	
}