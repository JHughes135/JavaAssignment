package com.languageanalyser;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

import org.apache.commons.lang3.*;



public class Line 
{
	
	private JFileChooser fc = new JFileChooser("C:\\Users\\hughe\\OneDrive\\Documents\\College\\2nd Year\\Object Orientated programming\\Java\\Assignment\\LanguageAnalyser");
	private Scanner input;
	private File inFile;
	public static int noOfLines;
	public static int fullStopCount, upperCaseCount;
	
	
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
			input = new Scanner(inFile);
			
			while (input.hasNextLine()) 
			{		
				line = input.nextLine();
				
				lineCount();
				fullStopCount();
				upperCase();
				
				Sentence sent = new Sentence(line);
									
			}
			
	
						
		} 
		catch (FileNotFoundException e1) 
			{
				System.out.println("Error");
			}
			
		input.close();
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
	


	public String toString() 
	{
		return line ;
	}
	
	
	
}