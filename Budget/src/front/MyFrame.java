package front;


import javax.swing.*;

public class MyFrame extends JFrame{

	public FrontPanel front;
	public WritingPanel write;
	public LoginPanel login;
	public BeforeAnalyzePanel beforeAnalyze;
	public AnalyzePanelCalender analyzeCalender;
	public AnalyzePanel analyze;

	private String[][] tmp;
	private int count;

	MyFrame(){

		front = new FrontPanel();
		login = new LoginPanel();
		beforeAnalyze = new BeforeAnalyzePanel();
		setTitle("다람이 가계부 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(login);
		setVisible(true);
		setSize(1730,1080);

	}

	public void change(String panelName){

		this.getContentPane().removeAll();

		if(panelName == "writing"){

			
			count = SavingInfo.getcnt();
			tmp = SavingInfo.getInfo();
			write = new WritingPanel(tmp, count);
			
			this.getContentPane().add(write);
		
		}

		if(panelName=="home"){
			this.getContentPane().add(front);
		}

		if(panelName=="beforeanalyze"){
			this.getContentPane().add(beforeAnalyze);
		}

		if(panelName=="analyzecalender"){
			String[][] data;
			int cnt;
			data = SavingInfo.getInfo();
			cnt = SavingInfo.getcnt();
			analyzeCalender = new AnalyzePanelCalender(data, cnt);
			this.getContentPane().add(analyzeCalender);
		}

		if(panelName=="analyze"){
			String[][] data;
			int cnt;
			data = SavingInfo.getInfo();
			cnt = SavingInfo.getcnt();
			analyze = new AnalyzePanel(data, cnt);
			this.getContentPane().add(analyze);
		}


		revalidate();
		repaint();


	}



}
