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


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JPanel;


public class GUI extends JFrame 
{
	private JPanel title, main;
	private JLabel text1;
	private JButton fcButton;
	private JRadioButton emailLetterButton;
	private JRadioButton textFileButton;
	private ButtonGroup fileTypeGroup;
	public Line line1;
	public static boolean formal = true;
	
	public GUI()
	{
		
		super("Language Analyser");
		setLayout(new FlowLayout());
		
		title = new JPanel(new FlowLayout());
		main = new JPanel(new FlowLayout());
		
		text1 = new JLabel("Language Analyser");
		text1.setFont(new Font("Serif", Font.PLAIN, 36 ));
		title.add(text1);
		
		fcButton = new JButton("Choose File");
		fcButton.addActionListener(new ActionListener()		
		{
			public void actionPerformed(ActionEvent e) 
			{
				reset(); //resets variables for multiple uses
				line1 = new Line();
				
				System.out.println(line1);
				formal = formalityCalc();
				
				System.out.printf("\n\nNumber of Lines: %d\n", Line.getNoOfLines());
				System.out.printf("Number of Full Stops: %d\n", Line.getFullStopCount());
				System.out.printf("Upper Case Letters: %d\n", Line.getUpperCaseCount());
				System.out.printf("Word Count: %f\n", Line.getNoOfWords());
				System.out.printf("Number of characters: %f\n", Word.getNoOfLetters());
				System.out.printf("Average word length: %f\n", Word.getAvgWordLength());
				System.out.printf("Sentences: %f\n", Sentence.getNoOfSentences());
				System.out.printf("Bad Words: %f\n", Word.getBadWords());
				System.out.printf("formal words: %f\n", Word.getFormalWords());
				
				if(formal == true)
				{
					JOptionPane.showMessageDialog(main, "Text is formal");
				}
				else if(formal == false)
				{
					JOptionPane.showMessageDialog(main,"Text is informal");
				}					
			}	
		});
				
		emailLetterButton = new JRadioButton("Email / Letter");
		emailLetterButton.setFont(new Font("Serif", Font.PLAIN, 18));
		
		textFileButton = new JRadioButton("Text file");
		textFileButton.setFont(new Font("Serif", Font.PLAIN, 18));
		
		fileTypeGroup = new ButtonGroup ();
		fileTypeGroup.add(emailLetterButton);
		fileTypeGroup.add(textFileButton);
		
		main.add(emailLetterButton);
		main.add(textFileButton);
		main.add(fcButton);
	}
	
	
//--------------------------------------------
//	Function to display GUI on Screen
//--------------------------------------------
	public void displayGUI()
	{
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(1200, 700);
		
		this.getContentPane().setLayout(new GridLayout(2,1));
	    this.getContentPane().add(title);
	    this.getContentPane().add(main);
		
	    this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	
	public boolean formalityCalc()
	{
		float formality = 0;
		
		if(Word.getBadWords() > Word.getFormalWords())
		{
			formality--;
		}
		
		if(Line.getFullStopCount() >= Line.getUpperCaseCount())
		{
			formality++;
		}
		
		if(Word.getFormalWords() > 0)
		{
			formality++;
		}
		
		if(formality > 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
				

	}
	
	public void reset()
	{
		Line.setNoOfLines(0);
		Line.setFullStopCount(0);
		Line.setUpperCaseCount(0);
		Line.setNoOfWords(0);
		Word.setNoOfLetters(0);
		Word.setAvgWordLength(0);
		Sentence.setNoOfSentences(0);
		Word.setBadWords(0);
		Word.setFormalWords(0);
		
	}

}