package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;


public class ChangePanel implements ActionListener{

	final String serverIP = "localhost";
	
	public void actionPerformed(ActionEvent e){
		JButton b = (JButton)e.getSource();
		
		/*ImageIcon oldIcon2 = new ImageIcon("./resources/homeButton.jpg");
		Image oldImage2 = oldIcon2.getImage();
		Image newImage2 = oldImage2.getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newImage2);*/
		
		if(b.getText().equals("가계부 작성")){
			try {
				Thread.sleep(20);
				SavingInfo si = new SavingInfo();
				si.run();
				Main.fr.change("writing");
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
		}
		
		if(b.getText().equals("홈")){
			
			try {
				
				Socket client = new Socket(serverIP, 5000);
				OutputStream out = client.getOutputStream();
				OutputStreamWriter outw = new OutputStreamWriter(out);
				BufferedWriter bw = new BufferedWriter(outw);
				
				bw.write("finish" + '\n');
				bw.flush();
				
				out.close();
				outw.close();
				bw.close();
				client.close();
				
				Main.fr.change("home");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(b.getText().equals("가계부 분석")){
			Main.fr.change("beforeanalyze");
		}
		
		if(b.getText().equals("달력 분석")){
			Main.fr.change("analyzecalender");
		}
		
		if(b.getText().equals("일반 분석")){
			Main.fr.change("analyze");
		}
		
		if(b.getText().equals("뒤로")){
			Main.fr.change("beforeanalyze");
		}
	}

}
