package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ChangePanel implements ActionListener{

	
	public void actionPerformed(ActionEvent e){
		JButton b = (JButton)e.getSource();
		
		ImageIcon oldIcon2 = new ImageIcon("./resources/homeButton.jpg");
		Image oldImage2 = oldIcon2.getImage();
		Image newImage2 = oldImage2.getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newImage2);
		
		if(b.getText().equals("가계부 작성")){
			Main.fr.change("writing");
		}
		
		if(b.getText().equals("홈")){
			Main.fr.change("home");
		}
		
	}

}
