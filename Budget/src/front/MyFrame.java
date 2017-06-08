package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyFrame extends JFrame{
	
	public FrontPanel front;
	public WritingPanel write;
	public LoginPanel login;
	public BeforeAnalyzePanel beforeAnalyze;
	public AnalyzePanelCalender analyzeCalender;
	public AnalyzePanel analyze;
	
	MyFrame(){
		
		front = new FrontPanel();
		write = new WritingPanel();
		login = new LoginPanel();
		beforeAnalyze = new BeforeAnalyzePanel();
		analyzeCalender = new AnalyzePanelCalender();
		analyze = new AnalyzePanel();
		setTitle("다람이 가계부 프로그램");
<<<<<<< HEAD
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().add(login);

=======
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(front);
>>>>>>> branch 'master' of https://github.com/yu4763/SoftwarePractice1
		setVisible(true);
		setSize(1730,1080);
	
	}
	
	public void change(String panelName){
		
		this.getContentPane().removeAll();
		
		if(panelName == "writing"){
			this.getContentPane().add(write);			
		}
		
		if(panelName=="home"){
			this.getContentPane().add(front);
		}
		
		if(panelName=="beforeanalyze"){
			this.getContentPane().add(beforeAnalyze);
		}
		
		if(panelName=="analyzecalender"){
			this.getContentPane().add(analyzeCalender);
		}
		
		if(panelName=="analyze"){
			this.getContentPane().add(analyze);
		}
		
		
		revalidate();
		repaint();
	
				
	}
		

	
}
