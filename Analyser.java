package com.languageanalyser;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;




public class Analyser 
{
	
	private JFileChooser fc = new JFileChooser();
	public Scanner input;
	public File inFile;
	public FileInputStream inPFile;
	public PrintWriter pw;
	
	public ArrayList<String> sentence;
	public String line;
	
	public String part1;
	public String part2;
	
	
	//-------------------------------
	//  Method for choosing file
	//-------------------------------
	public void chooseFile() 
	{
		fc.setDialogTitle("Analyser");
		if(fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) 
		{
				analyseControl();	
		}
	}//end of chooseFile
	

	//------------------------------------------------
	//Method that controls overall analysis of file
	//------------------------------------------------
	public void analyseControl() 
	{
		inFile = fc.getSelectedFile();
		
		try 
		{
			input = new Scanner(inFile);
			
			while (input.hasNext()) 
			{		
				line = input.nextLine();
		
				sentenceLength(line);							
			}
		} 
		catch (FileNotFoundException e1) 
			{
				System.out.println("Error");
			}
			
		input.close();
		}//end of analyseControl
	
	
	//--------------------------------------
	//Method to determine sentence length
	//--------------------------------------
	public int sentenceLength(String lineToSent)
	{
		
		int noOfWords = 0;
		
		String[] sentences = lineToSent.split(Pattern.quote("."), 2);
		
		
		/**
		for(String temp :sentences)
		{
		System.out.println(temp);
		}
		*/
		
		String[] words = sentences[0].split("//s");
		
		for(int i=0; i<words.length; i++) {
			
			
			System.out.printf("%s \n", words[i]);
			noOfWords++;
		}
		
		return noOfWords;
		
	}//end of sentenceLength
	

}