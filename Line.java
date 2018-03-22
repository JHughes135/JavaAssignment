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
	public static int fullStopCount;
	
	public String line;

	public Line() 
	{
		fc.setDialogTitle("Analyser");
		if(fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) 
		{
				analyseControl();	
		}
	}//end of chooseFile
	

	public void analyseControl() 
	{
		inFile = fc.getSelectedFile();
		
		try 
		{
			input = new Scanner(inFile);
			
			while (input.hasNextLine()) 
			{		
				line = input.nextLine();
				
				noOfLines ++;
				fullStopCount();
				
				Sentence sent = new Sentence(line);
									
			}
		
			System.out.println(fullStopCount);
			
		} 
		catch (FileNotFoundException e1) 
			{
				System.out.println("Error");
			}
			
		input.close();
	}//end of analyseControl
	
	public int lineCount()
	{
		return noOfLines;
	}
	
	
	public void fullStopCount() 
	{
		fullStopCount += StringUtils.countMatches(line, ".");
			
	}


	public String toString() 
	{
		return line ;
	}
	
	
	
}