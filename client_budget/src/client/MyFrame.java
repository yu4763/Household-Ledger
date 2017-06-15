package client;


import javax.swing.*;

import javax.swing.*;

/**
 * client에서 가장 밑의 바탕이 되는 틀. 이 프레임 위에 경우에 맞는 판넬을 올려서 사용자에게 보여줌. (처음 초기화는 LoginPanel)
 * @author team 6
 *
 */
public class MyFrame extends JFrame{

	public FrontPanel front;
	public WritingPanel write;
	public LoginPanel login;
	public BeforeAnalyzePanel beforeAnalyze;
	public AnalyzePanelCalender analyzeCalender;
	public AnalyzePanel analyze;

	private String[][] tmp;
	private int count;

	/**
	 *  client에서 가장 밑의 바탕이 되는 틀을 생성.
	 *  처음 초기화는 LoginPanel
	 */
	MyFrame(){

		front = new FrontPanel();
		login = new LoginPanel();
		beforeAnalyze = new BeforeAnalyzePanel();
		setTitle("다람이 가계부");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(login);
		setVisible(true);
		setSize(1730,1080);

	}

	/**
	 * 사용자가 누른 버튼의 정보에 따라 ChangePanel class에서 호출하는 함수.
	 * panelName에 따라 Frame 위에 올리는 판넬을 바꿈!
	 * @param panelName 	만들어진 Frame 위에 올릴 판넬에 대한 정보
	 */
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