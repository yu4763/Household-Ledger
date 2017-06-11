package front;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AnalyzePanel extends JPanel implements ActionListener{
	
	JLabel l;
	
	JPanel cir;
	ChartPanel graph = new ChartPanel();
	
	Calendar today;
	JPanel pmonth;
	JPanel color;
	JButton before;
	JButton after;
	JTextField TcurrentYear;
	JTextField TcurrentMonth;
	int currentYear;
	int currentMonth;
	
	SavingInfo info = new SavingInfo();
	String[][] dataCSV = new String[100][9];
	int cnt;
	int leftMoney;
	int[] spentMoney = new int[5]; //ī�װ��� ���� ��
	int[] arcAngle = new int[5];
	
	Font titlef = new Font("���ﳲ��ü B", Font.PLAIN, 30);
	Font contentf = new Font("���ﳲ��ü L", Font.PLAIN, 25);
	
	Color[] colors = {new Color(185,24,35),new Color(231,146,20),new Color(138,186,43),new Color(50,175,219),new Color(135,17,126)};
	String[] cate = {"�ĺ�","�����","��ȭ��Ȱ��","�к�","����"};
	
	AnalyzePanel(){
		setLayout(null);
		
		ImageIcon oldIcon = new ImageIcon("./resources/darami.jpg");
		Image oldImage = oldIcon.getImage();
		Image newImage = oldImage.getScaledInstance(1700,1000,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImage);		
		l = new JLabel(newIcon);
		l.setSize(1700,1000);
		l.setLocation(0,0);
		
		
		/* Ȩ ��ư */
		JButton home = new JButton("Ȩ");
		home.setSize(80,80);
		home.setLocation(100,80);
		home.setBackground(new Color(236,230,204));
		home.setFont(titlef);
		l.add(home);
		
		home.addActionListener(new ChangePanel());
		/* Ȩ��ư �Ϸ� */
		
		
		/* �ڷ� ��ư */
		JButton back = new JButton("�ڷ�");
		back.setSize(130,80);
		back.setLocation(250,80);
		back.setBackground(new Color(236,230,204));
		back.setFont(titlef);
		l.add(back);
		
		back.addActionListener(new ChangePanel());
		/* �ڷ� ��ư �Ϸ� */
		
		
		
		/* ���� �׷��� �� */
		pmonth = new JPanel();
		pmonth.setLocation(500,180);
		pmonth.setSize(650,100);
		pmonth.setOpaque(false);

		today = Calendar.getInstance();
		currentYear = today.get(Calendar.YEAR);
		currentMonth = today.get(Calendar.MONTH)+1;
		
		before = new JButton("before");
		after = new JButton("after");
		TcurrentYear = new JTextField(currentYear+"��");
		TcurrentMonth = new JTextField(currentMonth+"��");
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
		
		/* �� �Ϸ� */

		
		/* ���� �׷��� */
		cir = new JPanel();
		cir.setSize(500,500);
		cir.setLocation(300,400);
		cir.setOpaque(false);
		
		buttonSet();
		cir.add(graph);
		l.add(cir);

		before.addActionListener(this);
			

		after.addActionListener(this);
		
		/* ���� �׷��� �Ϸ�*/
		
		add(l);
		setSize(1700,1000);
	}
	
	void drawChart(){
		int sum = 0;
		for(int i=0;i<5;i++){
			sum+=spentMoney[i];
		}
		if(sum==0) return;
		for(int i=0;i<5;i++){
			arcAngle[i] = (int)Math.round((double)spentMoney[i]/(double)sum*360);
			graph.repaint();
		}
	}
	
	class ChartPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			int angle=0;
			/*for(int i=0;i<5;i++){
				g.setColor(colors[i]);
				g.drawString(cate[i]+Math.round(arcAngle[i]*100/360+"%",50+i*100,20));
			}*/
			for(int i=0;i<5;i++){
				g.setColor(colors[i]);
				g.fillArc(150,50,200,200,angle,arcAngle[i]);
				angle += arcAngle[i];
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
		dataCSV = info.getInfo();
		cnt = info.getcnt();
		
		color = new JPanel();
		color.setLocation(300,800);
		color.setSize(1000,120);
		color.setOpaque(false);
		
		JButton b1 = new JButton();
		JButton b2 = new JButton();
		JButton b3 = new JButton();
		JButton b4 = new JButton();
		JButton b5 = new JButton();
		JButton bexpense = new JButton();
		JButton bleftMoney = new JButton();

		int dataCSVIntCost,dataCSVIntYear,dataCSVIntMonth;
		for(int i=0;i<cnt;i++){
			dataCSVIntYear = Integer.parseInt(dataCSV[i][1]);
			dataCSVIntMonth = Integer.parseInt(dataCSV[i][2]);
			if(dataCSVIntYear==currentYear && dataCSVIntMonth==currentMonth){
				dataCSVIntCost = Integer.parseInt(dataCSV[i][8]);
				if(dataCSV[i][5]=="����"){
					if(dataCSV[i][4]=="�ĺ�"){
						spentMoney[0] += dataCSVIntCost;
					}
					else if(dataCSV[i][4]=="�����"){
						spentMoney[1] += dataCSVIntCost;
					}
					else if(dataCSV[i][4]=="��ȭ��Ȱ��"){
						spentMoney[2] += dataCSVIntCost;
					}
					else if(dataCSV[i][4]=="�к�"){
						spentMoney[3] += dataCSVIntCost;
					}
					else if(dataCSV[i][4]=="����"){
						spentMoney[4] += dataCSVIntCost;
					}
					
				}
			}
		}
		
		/* �� ���� */
		int sumExpense = 0;
		for(int i=1;i<5;i++){
			sumExpense += spentMoney[i];
		}
		
		/* leftMoney ������ 5���̶�� 5������ ���� ��*/
		leftMoney = 0;
		for(int i=0;i<cnt;i++){
			dataCSVIntYear = Integer.parseInt(dataCSV[i][1]);
			dataCSVIntMonth = Integer.parseInt(dataCSV[i][2]);
			if(dataCSVIntYear<currentYear || (dataCSVIntYear==currentYear && dataCSVIntMonth<currentMonth)){
				dataCSVIntCost = Integer.parseInt(dataCSV[i][8]);
				if(dataCSV[i][5]=="����") leftMoney += dataCSVIntCost;
				else if(dataCSV[i][5]=="����") leftMoney -= dataCSVIntCost;
			}
		}
		
		b1.setText("�ĺ�:"+spentMoney[0]+"��");
		b2.setText("�����:"+spentMoney[1]+"��");
		b3.setText("��ȭ��Ȱ��:"+spentMoney[2]+"��");
		b4.setText("�к�:"+spentMoney[3]+"��");
		b5.setText("����:"+spentMoney[4]+"��");
		bexpense.setText("�� ����:"+sumExpense+"��");
		bleftMoney.setText("������:"+leftMoney+"��");
		
		b1.setForeground(new Color(185,24,35));
		b2.setForeground(new Color(231,146,20));
		b3.setForeground(new Color(138,186,43));
		b4.setForeground(new Color(50,175,219));
		b5.setForeground(new Color(135,17,126));
		//b6.setForeground(new Color(235,205,213));
		//b7.setForeground(new Color(209,175,148));
		
		b1.setFont(titlef);
		b1.setBackground(new Color(255,255,255));
		b1.setOpaque(false);
		b2.setFont(titlef);
		b2.setBackground(new Color(255,255,255));
		b2.setOpaque(false);
		b3.setFont(titlef);
		b3.setBackground(new Color(255,255,255));
		b3.setOpaque(false);
		b4.setFont(titlef);
		b4.setBackground(new Color(255,255,255));
		b4.setOpaque(false);
		b5.setFont(titlef);
		b5.setBackground(new Color(255,255,255));
		b5.setOpaque(false);
		bexpense.setFont(titlef);
		bexpense.setBackground(new Color(255,255,255));
		bexpense.setOpaque(false);
		bleftMoney.setFont(titlef);
		bleftMoney.setBackground(new Color(255,255,255));
		bleftMoney.setOpaque(false);
		
		color.add(b1);
		color.add(b2);
		color.add(b3);
		color.add(b4);
		color.add(b5);
		color.add(bexpense);
		color.add(bleftMoney);
		
		color.setLayout(new GridLayout(7,1));
		
		l.add(color);
		
		drawChart();
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==before){
			this.pmonth.removeAll();
			calInput(-1);
			buttonSet();
			this.TcurrentYear.setText(currentYear+"��");
			this.TcurrentMonth.setText(currentMonth+"��");
		}
		else if(arg0.getSource()==after){
			this.pmonth.removeAll();
			calInput(1);
			buttonSet();
			this.TcurrentYear.setText(currentYear+"��");
			this.TcurrentMonth.setText(currentMonth+"��");
		}		
	}
}
