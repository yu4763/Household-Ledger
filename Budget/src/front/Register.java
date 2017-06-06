package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Register implements ActionListener{
	
	String userID;
	char[] password;
	
	Register(String id){
		userID = id;
	}

	
	public void actionPerformed(ActionEvent e){
		System.out.println("Button!");
		JButton b = (JButton)e.getSource();
		
		System.out.println(b.getText());
		System.out.println(userID);
		
		
		if(b.getText().equals("회원가입") && userID != null){
			System.out.println("Go client!");
			Client c = new Client(userID);
		}
		
		
	}

}

