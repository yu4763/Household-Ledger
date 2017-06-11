package front;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AnalyzePanelCalender extends JPanel implements ActionListener{
	
	Calendar today;
	Calendar cal;
	int currentYear,currentMonth,currentDay;
	JButton before;
	JButton after;
	JPanel calendar;
	JPanel calendarDays;
	JTextField TcurrentMonth;
	JTextField TcurrentYear;
	JTextField TcurrentTime;
	//JButton[] Bcal = new JButton[49];
	JTextArea[] Tcal = new JTextArea[49];
	String days[] = {"��","��","ȭ","��","��","��","��"};
	
	Font titlef = new Font("���ﳲ��ü B", Font.PLAIN, 30);
	Font contentf = new Font("���ﳲ��ü L", Font.PLAIN, 25);
	Font contentf2 = new Font("���ﳲ��ü L", Font.PLAIN, 17);
	
	
	String[][] dataCSV = new String[100][9];
	int cnt;
	int leftMoney;
	
	AnalyzePanelCalender(String[][] data, int cnt){
		
		this.dataCSV = data;
		this.cnt = cnt;
		
		setLayout(null);
		
		ImageIcon oldIcon = new ImageIcon("./resources/darami.jpg");
		Image oldImage = oldIcon.getImage();
		Image newImage = oldImage.getScaledInstance(1700,1000,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImage);		
		JLabel l = new JLabel(newIcon);
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
		
		
		/* �޷� */
		/* �޷� ���� ���� �ǳ� */
		calendar = new JPanel();
		calendar.setFont(titlef);
		calendar.setSize(650,100);
		calendar.setLocation(500,150);
		calendar.setOpaque(false);
		
		today = Calendar.getInstance();
		cal = new GregorianCalendar();
		
		currentYear = today.get(Calendar.YEAR);
		currentMonth = today.get(Calendar.MONTH)+1;
		currentDay=0;
		
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
		
		calendar.add(before);
		calendar.add(TcurrentYear);
		calendar.add(TcurrentMonth);
		calendar.add(after);
		TcurrentYear.setEnabled(false);
		TcurrentMonth.setEnabled(false);
		
		l.add(calendar);
		
		/* �޷� �Ʒ��� �� �׸��� �κ� */
		calendarDays = new JPanel(new GridLayout(7,7));
		calendarDays.setFont(contentf);
		calendarDays.setSize(1200,700);
		calendarDays.setLocation(220,200);
		calendarDays.setOpaque(false);
		
		l.add(calendarDays);
		
		gridInit();
		panelInit();
		calSet();
		hideInit();
		
		
		before.addActionListener(this);
		after.addActionListener(this);
		
		//�޷� �Ϸ�
		
		add(l);
		setSize(1700,1000);
	}

	private void hideInit() { //������ ��ư ��Ȱ��ȭ
		for(int i=0;i<Tcal.length;i++){
			if((Tcal[i].getText()).equals("")) Tcal[i].setEnabled(false);
		}		
	}

	private void gridInit() {
		for(int i=0;i<days.length;i++){
			calendarDays.add(Tcal[i]=new JTextArea(days[i]));
			Tcal[i].setFont(contentf);
		}
		for(int i=days.length;i<49;i++){
			calendarDays.add(Tcal[i]=new JTextArea(""));
		}
	}
	
	private void panelInit(){
		GridLayout gridLayout = new GridLayout(7,7);
		calendarDays.setLayout(gridLayout);
	}

	private void calSet() {
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		dataCSV = SavingInfo.getInfo();
		cnt = SavingInfo.getcnt();
		
		cal.set(Calendar.YEAR,currentYear);
		cal.set(Calendar.MONTH,currentMonth-1);
		cal.set(Calendar.DATE,1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		/* ����, ����, �� */
		int[] earning = new int[32];
		int[] expense = new int[32];
		int[] sum = new int[32];
		int dataCSVIntCost,dataCSVIntYear,dataCSVIntMonth,dataCSVIntDay;
		for(int i=0;i<cnt;i++){
			dataCSVIntYear = Integer.parseInt(dataCSV[i][1]);			
			dataCSVIntMonth = Integer.parseInt(dataCSV[i][2]);			
			if(dataCSVIntYear==currentYear && dataCSVIntMonth==currentMonth){
				dataCSVIntCost = Integer.parseInt(dataCSV[i][8]);
				dataCSVIntDay = Integer.parseInt(dataCSV[i][3]);
				if(dataCSV[i][5].equals("����")){
					earning[dataCSVIntDay] += dataCSVIntCost;
				}
				else if(dataCSV[i][5].equals("����")){
					expense[dataCSVIntDay] += dataCSVIntCost;
				}
			}
		}
		for(int i=1;i<32;i++){
			sum[i] = earning[i] - expense[i];
		}		
		
		/* leftMoney ������ 5���̶�� 4������ ���� �� */
		leftMoney = 0;
		for(int i=0;i<cnt;i++){
			dataCSVIntYear = Integer.parseInt(dataCSV[i][1]);
			dataCSVIntMonth = Integer.parseInt(dataCSV[i][2]);
			if(dataCSVIntYear<currentYear || (dataCSVIntYear==currentYear && dataCSVIntMonth<currentMonth)){
				dataCSVIntCost = Integer.parseInt(dataCSV[i][8]);
				if(dataCSV[i][5].equals("����")) leftMoney += dataCSVIntCost;
				else if(dataCSV[i][5].equals("����")) leftMoney -= dataCSVIntCost;
			}
		}
		
		int hopping = 0;
		Tcal[0].setForeground(new Color(255,0,0)); //��
		Tcal[6].setForeground(new Color(0,0,255)); //��
		for(int i=cal.getFirstDayOfWeek();i<dayOfWeek;i++) hopping++;
		
		for(int i=0;i<hopping;i++){
			Tcal[i+7].setText("");
		}
		for(int i=0;i<49;i++){ //��� �����ϰ�
			Tcal[i].setBackground(new Color(255,255,255));
			Tcal[i].setOpaque(false);
		}
		for(int i=cal.getMinimum(Calendar.DAY_OF_MONTH);i<=cal.getMaximum(Calendar.DAY_OF_MONTH);i++){
			cal.set(Calendar.DATE,i);
			if(cal.get(Calendar.MONTH)!=currentMonth-1) break;
			Tcal[i+6+hopping].setForeground(new Color(0,0,0)); //����
			if((i+hopping-1)%7==0) Tcal[i+6+hopping].setForeground(new Color(255,0,0)); //��
			if((i+hopping)%7==0) Tcal[i+6+hopping].setForeground(new Color(0,0,255)); //��
			leftMoney += sum[i];
			Tcal[i+6+hopping].setText((i)+"\n"+" ���� : "+(earning[i])+"��\n ���� : "+(expense[i])+"��\n �� : "+sum[i]+"��\n ������ : "+leftMoney+"��");
			Tcal[i+6+hopping].setFont(contentf2);
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

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==before){
			this.calendarDays.removeAll();
			calInput(-1);
			gridInit();
			panelInit();
			calSet();
			hideInit();
			this.TcurrentYear.setText(currentYear+"��");
			this.TcurrentMonth.setText(currentMonth+"��");
		}
		else if(arg0.getSource()==after){
			this.calendarDays.removeAll();
			calInput(1);
			gridInit();
			panelInit();
			calSet();
			hideInit();
			this.TcurrentYear.setText(currentYear+"��");
			this.TcurrentMonth.setText(currentMonth+"��");
		}		
	}
}