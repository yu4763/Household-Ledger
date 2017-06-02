package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ChangePanel implements ActionListener{

	
	public void actionPerformed(ActionEvent e){
		JButton b = (JButton)e.getSource();
		
		if(b.getText().equals("가계부 작성")){
			Main.fr.change("writing");
		}
	}

}
