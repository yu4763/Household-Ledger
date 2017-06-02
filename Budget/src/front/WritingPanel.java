package front;

import java.awt.*;
import javax.swing.*;

public class WritingPanel extends JPanel{
	
	ImageIcon daram;
	
	WritingPanel(){

		setLayout(null);
	
		ImageIcon oldIcon = new ImageIcon("./resources/darami.jpg");
		Image oldImage = oldIcon.getImage();
		Image newImage = oldImage.getScaledInstance(1700,1000,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImage);
		JLabel l = new JLabel(newIcon);
		l.setSize(1700,1000);
		l.setLocation(0,0);
		
		add(l);
		setSize(1700,1000);
		
	}

}
