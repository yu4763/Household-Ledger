package client;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AnalyzePanel extends JPanel implements ActionListener{
	
	private JLabel l;
	
	private JPanel cir;
	private ChartPanel graph = new ChartPanel();
	
	private Calendar cal;
	private Calendar today;
	private JPanel pmonth;
	private JPanel color;
	private JButton before;
	private JButton after;
	private JTextField TcurrentYear;
	private JTextField TcurrentMonth;
	private int currentYear;
	private int currentMonth;
	
	private JTextArea T1,T2,T3,T4,T5,Texpense;
	
	Font titlef = new Font("서울남산체 B", Font.PLAIN, 30);
	
	
	private String[][] dataCSV = new String[100][9];
	private int cnt;
	private int[] spentMoney = new int[5]; //카테고리별 지출 돈
	private int[] arcAngle = new int[5];
	
	
	
	Color[] colors = {new Color(185,24,35),new Color(231,146,20),new Color(138,186,43),new Color(50,175,219),new Color(135,17,126)};
	private String[] cate = {"식비","교통비","문화생활비","학비","저축"};
	private int sum;
	
	
	AnalyzePanel(String[][] data, int cnt){
		this.dataCSV = data;
		this.cnt = cnt;
		setLayout(null);
		
		
		
		ImageIcon oldIcon = new ImageIcon("./resources/darami.jpg");
		Image oldImage = oldIcon.getImage();
		Image newImage = oldImage.getScaledInstance(1700,1000,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImage);		
		l = new JLabel(newIcon);
		l.setSize(1700,1000);
		l.setLocation(0,0);
		
		
		/* 홈 버튼 */
		JButton home = new JButton("홈");
		home.setSize(80,80);
		home.setLocation(100,80);
		home.setBackground(new Color(236,230,204));
		home.setFont(titlef);
		l.add(home);
		
		home.addActionListener(new ChangePanel());
		/* 홈버튼 완료 */
		
		
		/* 뒤로 버튼 */
		JButton back = new JButton("뒤로");
		back.setSize(130,80);
		back.setLocation(250,80);
		back.setBackground(new Color(236,230,204));
		back.setFont(titlef);
		l.add(back);
		
		back.addActionListener(new ChangePanel());
		/* 뒤로 버튼 완료 */
		
		
		
		/* 원형 그래프 달 */
		pmonth = new JPanel();
		pmonth.setLocation(500,180);
		pmonth.setSize(650,100);
		pmonth.setOpaque(false);

		today = Calendar.getInstance();
		cal = new GregorianCalendar();
		currentYear = today.get(Calendar.YEAR);
		currentMonth = today.get(Calendar.MONTH)+1;
		
		before = new JButton("before");
		after = new JButton("after");
		TcurrentYear = new JTextField(currentYear+"년");
		TcurrentMonth = new JTextField(currentMonth+"월");
		before.setFont(titlef);
		after.setFont(titlef);
		TcurrentYear.setFont(titlef);
		TcurrentMonth.setFont(titlef);
		before.setBackground(new Color(255,255,255));
		before.setOpaque(false);
		before.setBorderPainted(false);
		after.setBackground(new Color(255,255,255));
		after.setOpaque(false);
		after.setBorderPainted(false);
		
		pmonth.add(before);
		pmonth.add(TcurrentYear);
		pmonth.add(TcurrentMonth);
		pmonth.add(after);
		TcurrentYear.setEnabled(false);
		TcurrentMonth.setEnabled(false);
		
		l.add(pmonth);
		
		/* 달 완료 */
		

		T1 = new JTextArea();
		T2 = new JTextArea();
		T3 = new JTextArea();
		T4 = new JTextArea();
		T5 = new JTextArea();
		Texpense = new JTextArea();
		
		
		/* 원형 그래프 */
		cir = new JPanel();
		cir.setSize(500,500);
		cir.setLocation(300,400);
		
		before.addActionListener(this);
		after.addActionListener(this);
		
		graph.setSize(700,700);
		graph.setLocation(300,300);
		graph.setOpaque(false);
		
		buttonSet();
		drawChart();
		
		l.add(graph);
		
		/* 원형 그래프 완료*/
		
		add(l);
		setSize(1700,1000);
	}
	
	void drawChart(){
		sum = 0;
		for(int i=0;i<5;i++){
			sum+=spentMoney[i];
		}
		if(sum!=0){
			for(int i=0;i<5;i++){
				arcAngle[i] = (int)Math.round((double)spentMoney[i]/(double)sum*360);
			}
		}
		repaint();
	}
	
	class ChartPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if(sum!=0){
				int angle=0;
				for(int i=0;i<5;i++){
					g.setColor(colors[i]);
					g.drawString(cate[i]+""+Math.round(arcAngle[i]*100/360)+"%", 50+i*100,20);
				}
				for(int i=0;i<5;i++){
					g.setColor(colors[i]);
					g.fillArc(100,50,500,500,angle,arcAngle[i]);
					angle += arcAngle[i];
				}
			}
			else{
				for(int i=0;i<5;i++){
					g.setColor(colors[i]);
					g.drawString(cate[i]+"0%", 50+i*100,20);
				}
				g.drawOval(100,50,500,500);
			}
		}
	}
	
	private void calInput(int d){
		currentMonth += d;
		if(currentMonth<=0){
			currentMonth = 12;
			currentYear -= 1;
		}
		else if(currentMonth>12){
			currentMonth = 1;
			currentYear += 1;
		}
	}
	
	private void buttonSet(){
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cal.set(Calendar.YEAR,currentYear);
		cal.set(Calendar.MONTH,currentMonth-1);
		
		color = new JPanel();
		color.setLocation(1020,340);
		color.setSize(350,600);
		color.setOpaque(false);
		
		for(int i=0;i<5;i++) spentMoney[i] = 0;

		int dataCSVIntCost,dataCSVIntYear,dataCSVIntMonth;
		for(int i=0;i<cnt;i++){
			dataCSVIntYear = Integer.parseInt(dataCSV[i][1]);
			dataCSVIntMonth = Integer.parseInt(dataCSV[i][2]);
			if(dataCSVIntYear==currentYear && dataCSVIntMonth==currentMonth){
				dataCSVIntCost = Integer.parseInt(dataCSV[i][8]);
				
				if(dataCSV[i][5].equals("지출")){
					if(dataCSV[i][4].equals("식비")){
						spentMoney[0] += dataCSVIntCost;
					}
					else if(dataCSV[i][4].equals("교통비")){
						spentMoney[1] += dataCSVIntCost;
					}
					else if(dataCSV[i][4].equals("문화생활비")){
						spentMoney[2] += dataCSVIntCost;
					}
					else if(dataCSV[i][4].equals("학비")){
						spentMoney[3] += dataCSVIntCost;
					}
					else if(dataCSV[i][4].equals("저축")){
						spentMoney[4] += dataCSVIntCost;
					}
					
				}
			}
		}	
		
		
		/* 총 지출 */
		int sumExpense = 0;
		for(int i=1;i<5;i++){
			sumExpense += spentMoney[i];
		}
		
		T1.setText("식비 : "+spentMoney[0]+"원");
		T2.setText("교통비 : "+spentMoney[1]+"원");
		T3.setText("문화생활비 : "+spentMoney[2]+"원");
		T4.setText("학비 : "+spentMoney[3]+"원");
		T5.setText("저축 : "+spentMoney[4]+"원");
		Texpense.setText("총 지출 : "+sumExpense+"원");
		
		T1.setForeground(new Color(185,24,35));
		T2.setForeground(new Color(231,146,20));
		T3.setForeground(new Color(138,186,43));
		T4.setForeground(new Color(50,175,219));
		T5.setForeground(new Color(135,17,126));
		
		T1.setFont(titlef);
		T1.setBackground(new Color(255,255,255));
		T1.setOpaque(false);
		T2.setFont(titlef);
		T2.setBackground(new Color(255,255,255));
		T2.setOpaque(false);
		T3.setFont(titlef);
		T3.setBackground(new Color(255,255,255));
		T3.setOpaque(false);
		T4.setFont(titlef);
		T4.setBackground(new Color(255,255,255));
		T4.setOpaque(false);
		T5.setFont(titlef);
		T5.setBackground(new Color(255,255,255));
		T5.setOpaque(false);
		Texpense.setFont(titlef);
		Texpense.setBackground(new Color(255,255,255));
		Texpense.setOpaque(false);
	
		color.add(T1);
		color.add(T2);
		color.add(T3);
		color.add(T4);
		color.add(T5);
		color.add(Texpense);
		
		color.setLayout(new GridLayout(7,1));
		
		l.add(color);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==before){
			calInput(-1);
			buttonSet();
			drawChart();
			this.TcurrentYear.setText(currentYear+"년");
			this.TcurrentMonth.setText(currentMonth+"월");
		}
		else if(arg0.getSource()==after){
			calInput(1);
			buttonSet();
			drawChart();
			this.TcurrentYear.setText(currentYear+"년");
			this.TcurrentMonth.setText(currentMonth+"월");
		}		
	}
}