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
	JButton[] Bcal = new JButton[49];
	String days[] = {"일","월","화","수","목","금","토"};
	
	Font titlef = new Font("서울남산체 B", Font.PLAIN, 30);
	Font contentf = new Font("서울남산체 L", Font.PLAIN, 25);
	Font contentf2 = new Font("서울남산체 L", Font.PLAIN, 10);
	
	SavingInfo info = new SavingInfo();
	String[][] dataCSV = new String[100][9];
	int cnt;
	int earning;
	int expense;
	
	AnalyzePanelCalender(){
		setLayout(null);
		
		ImageIcon oldIcon = new ImageIcon("./resources/darami.jpg");
		Image oldImage = oldIcon.getImage();
		Image newImage = oldImage.getScaledInstance(1700,1000,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImage);		
		JLabel l = new JLabel(newIcon);
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
		
		
		/* 달력 */
		/* 달력 위쪽 연월 판넬 */
		calendar = new JPanel();
		calendar.setFont(titlef);
		calendar.setSize(650,100);
		calendar.setLocation(500,150);
		calendar.setOpaque(false);
		
		today = Calendar.getInstance();
		cal = new GregorianCalendar();
		String months[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		
		currentYear = today.get(Calendar.YEAR);
		currentMonth = today.get(Calendar.MONTH)+1;
		currentDay=0;
		
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
		after.setBackground(new Color(255,255,255));
		after.setOpaque(false);
		
		calendar.add(before);
		calendar.add(TcurrentYear);
		calendar.add(TcurrentMonth);
		calendar.add(after);
		TcurrentYear.setEnabled(false);
		TcurrentMonth.setEnabled(false);
		
		l.add(calendar);
		
		/* 달력 아래쪽 일 그리드 부분 */
		calendarDays = new JPanel(new GridLayout(7,7));
		calendarDays.setFont(contentf);
		calendarDays.setSize(1200,700);
		calendarDays.setLocation(220,200);
		calendarDays.setOpaque(false);
		
		gridInit();
		calSet();
		hideInit();
		l.add(calendarDays);
		
		before.addActionListener(this);
		after.addActionListener(this);
		
		//달력 출력
		
		add(l);
		setSize(1700,1000);
	}

	private void hideInit() { //나머지 버튼 비활성화
		for(int i=0;i<Bcal.length;i++){
			if((Bcal[i].getText()).equals("")) Bcal[i].setEnabled(false);
		}		
	}

	private void gridInit() {
		for(int i=0;i<days.length;i++){
			calendarDays.add(Bcal[i]=new JButton(days[i]));
			Bcal[i].setFont(contentf);
			Bcal[i].setContentAreaFilled(false);
			Bcal[i].setBorderPainted(false);
		}
		for(int i=days.length;i<49;i++){
			calendarDays.add(Bcal[i]=new JButton(""));
			Bcal[i].addActionListener(this);
		}	
	}
	
	private void panelInit(){
		GridLayout gridLayout = new GridLayout(7,7);
		calendarDays.setLayout(gridLayout);
	}

	private void calSet() {
		dataCSV = info.getInfo();
		cnt = info.getcnt();
		
		cal.set(Calendar.YEAR,currentYear);
		cal.set(Calendar.MONTH,currentMonth-1);
		cal.set(Calendar.DATE,1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		String ScurrentYear = Integer.toString(currentYear);
		String ScurrentMonth = Integer.toString(currentMonth);
		
		for(int i=0;i<cnt;i++){
			if(dataCSV[i][1]==ScurrentYear && dataCSV[i][2]==ScurrentMonth){
				
			}
		}
		
		int hopping = 0;
		Bcal[0].setForeground(new Color(255,0,0)); //일
		Bcal[6].setForeground(new Color(0,0,255)); //토
		for(int i=cal.getFirstDayOfWeek();i<dayOfWeek;i++) hopping++;
		
		for(int i=0;i<hopping;i++){
			Bcal[i+7].setText("");
		}
		for(int i=0;i<49;i++){ //배경 투명하게
			Bcal[i].setBackground(new Color(255,255,255));
			Bcal[i].setOpaque(false);
		}
		for(int i=cal.getMinimum(Calendar.DAY_OF_MONTH);i<=cal.getMaximum(Calendar.DAY_OF_MONTH);i++){
			cal.set(Calendar.DATE,i);
			if(cal.get(Calendar.MONTH)!=currentMonth-1) break;
			Bcal[i+6+hopping].setForeground(new Color(0,0,0)); //평일
			if((i+hopping-1)%7==0) Bcal[i+6+hopping].setForeground(new Color(255,0,0)); //일
			if((i+hopping)%7==0) Bcal[i+6+hopping].setForeground(new Color(0,0,255)); //토
			Bcal[i+6+hopping].setText((i)+"");
			Bcal[i+6+hopping].setFont(contentf2);
			Bcal[i+6+hopping].setHorizontalAlignment(SwingConstants.LEFT);
			Bcal[i+6+hopping].setVerticalAlignment(SwingConstants.TOP);
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
			this.TcurrentYear.setText(currentYear+"년");
			this.TcurrentMonth.setText(currentMonth+"월");
		}
		else if(arg0.getSource()==after){
			this.calendarDays.removeAll();
			calInput(1);
			gridInit();
			panelInit();
			calSet();
			hideInit();
			this.TcurrentYear.setText(currentYear+"년");
			this.TcurrentMonth.setText(currentMonth+"월");
		}		
	}
}
