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
	
	public String line;
	
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
								
			}
		} 
		catch (FileNotFoundException e1) 
			{
				System.out.println("Error");
			}
			
		input.close();
		}//end of analyseControl
	
	
	

	//test
	
}