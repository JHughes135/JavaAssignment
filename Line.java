package com.languageanalyser;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;



public class Line 
{
	
	private JFileChooser fc = new JFileChooser("C:\\Users\\hughe\\OneDrive\\Documents\\College\\2nd Year\\Object Orientated programming\\Java\\Assignment\\LanguageAnalyser");
	private Scanner input;
	private File inFile;
	public int noOfLines;
	
	private String line;

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
				
				Sentence sent = new Sentence(line);
									
			}
			
		} 
		catch (FileNotFoundException e1) 
			{
				System.out.println("Error");
			}
			
		input.close();
	}//end of analyseControl


	public String toString() 
	{
		return line ;
	}
	
	
	//test 
	
	
}