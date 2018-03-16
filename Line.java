package com.languageanalyser;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;



public class Line 
{
	
	private JFileChooser fc = new JFileChooser();
	private Scanner input;
	private File inFile;
	
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
				
				Sentence sent = new Sentence(line);
				
				//System.out.printf("%s\n", line);
												
			}
			
			System.out.println("\n\n\n");
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
	
	
	
	
	
}