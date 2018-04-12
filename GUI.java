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
				
				System.out.printf("\n\nNumber of Lines: %d\n", Line.noOfLines);
				System.out.printf("Number of Full Stops: %d\n", Line.fullStopCount);
				System.out.printf("Upper Case Letters: %d\n", Line.upperCaseCount);
				System.out.printf("Word Count: %f\n", Line.noOfWords);
				System.out.printf("Number of characters: %f\n", Word.noOfLetters);
				System.out.printf("Average word length: %f\n", Word.avgWordLength);
				System.out.printf("Sentences: %f\n", Sentence.noOfSentences);
				System.out.printf("Bad Words: %f\n", Word.badWords);
				System.out.printf("formal words: %f\n", Word.formalWords);
				
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
		
		if(Word.badWords > Word.formalWords)
		{
			formality--;
		}
		
		if(Line.fullStopCount >= Line.upperCaseCount)
		{
			formality++;
		}
		
		if(Word.formalWords > 0)
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
		Line.noOfLines = 0;
		Line.fullStopCount = 0;
		Line.upperCaseCount = 0;
		Line.noOfWords = 0;
		Word.noOfLetters = 0;
		Word.avgWordLength = 0;
		Sentence.noOfSentences = 0;
		Word.badWords = 0;
		Word.formalWords = 0;
		
	}

}