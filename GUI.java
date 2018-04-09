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
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class GUI extends JFrame 
{
	
	private JPanel title, main;
	private JLabel text1;
	private JButton fcButton;
	private JRadioButton emailLetterButton;
	private JRadioButton textFileButton;
	private ButtonGroup fileTypeGroup;
	private JProgressBar scale;
	public Line line1;
	
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
				line1 = new Line();
				
				System.out.println(line1);
				

				System.out.printf("\n\nNumber of Lines: %d\n", Line.noOfLines);
				System.out.printf("Number of Full Stops: %d\n", Line.fullStopCount);
				System.out.printf("Upper Case Letters: %d", Line.upperCaseCount);
									
			}	
			
		});
		
		//int scaleNo = (formalityCalc(Line.noOfLines, Line.fullStopCount)) * 100;
		
		scale = new JProgressBar(0, 100);
		scale.setValue(0);
		scale.setStringPainted(true);
		
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
		main.add(scale);
		
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
	
	
	public float formalityCalc(int lines, int fullStops)
	{
		
		float formality;
		
		float fullStopRatio = lines/fullStops;
		//float commaRatio = commas/fullStops;
		
		formality = fullStopRatio; //+ commaRatio) / 2;
		
		
		return formality;
	}

}