package client;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 달력형 분석 창과 카테고리별 분석 창 둘 중 하나를 고르는 class
 * @author team 6
 *
 */
public class BeforeAnalyzePanel extends JPanel{
	
	private JLabel l;
	
	/**
	 * 기본 바탕과 홈으로 가는 버튼, 달력형 분석창으로 가는 버튼, 카테고리별 분석창으로 가는 버튼 생성
	 */
	BeforeAnalyzePanel(){
		setLayout(null);
		
		ImageIcon oldIcon = new ImageIcon("./resources/darami.jpg");
		Image oldImage = oldIcon.getImage();
		Image newImage = oldImage.getScaledInstance(1700,1000,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImage);		
		JLabel l = new JLabel(newIcon);
		l.setSize(1700,1000);
		l.setLocation(0,0);
		
		Font titlef = new Font("서울남산체 B", Font.PLAIN, 30);
		Font contentf = new Font("서울남산체 L", Font.PLAIN, 25);
		
		
		/* 홈 버튼 */
		JButton home = new JButton("홈");
		home.setSize(80,80);
		home.setLocation(100,80);
		home.setBackground(new Color(236,230,204));
		home.setFont(titlef);
		l.add(home);
		
		home.addActionListener(new ChangePanel());
		/* 홈버튼 완료 */
		
		
		/* 달력형 분석창 버튼 */
		JButton calender = new JButton("달력 분석");
		calender.setSize(270,100);
		calender.setLocation(570,450);
		calender.setBackground(new Color(236,230,204));
		calender.setFont(titlef);
		l.add(calender);
		
		calender.addActionListener(new ChangePanel());
		/* 달력형 분석창 버튼 완료*/
		
		
		/* 카테고리 분석창 버튼 */
		JButton analyze = new JButton("카테고리 분석");
		analyze.setSize(270,100);
		analyze.setLocation(920,450);
		analyze.setBackground(new Color(236,230,204));
		analyze.setFont(titlef);
		l.add(analyze);
		
		analyze.addActionListener(new ChangePanel());
		/* 카테고리 분석창 버튼 완료*/
		
		add(l);
		setSize(1700,1000);
	}
	
}
