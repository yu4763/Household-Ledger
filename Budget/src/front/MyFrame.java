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
		analyzeCalender = new AnalyzePanelCalender();
		analyze = new AnalyzePanel();
		setTitle("다람이 가계부 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().add(login);

		setVisible(true);
		setSize(1730,1080);

	}

	public void change(String panelName){

		this.getContentPane().removeAll();

		if(panelName == "writing"){

			int fin = SavingInfo.getfin();
			while(fin == 0){
				try {
					Thread.sleep(2);
					fin = SavingInfo.getfin();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
				
			}
			count = SavingInfo.getcnt();
			tmp = SavingInfo.getInfo();


			System.out.println(count);
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
			this.getContentPane().add(analyzeCalender);
		}

		if(panelName=="analyze"){
			this.getContentPane().add(analyze);
		}


		revalidate();
		repaint();


	}



}
