package com.sist.project;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.*;

public class Chat extends JPanel{
	JPanel p1=new JPanel();
	JTextArea ta=new JTextArea();
	JScrollPane js=new JScrollPane(ta);
	JTextField tf=new JTextField();
	JPanel p2=new JPanel();
	JButton back=new JButton("¿Ã¿¸");
	
	Chat()
	{
		setLayout(null);
		p1.setBackground(Color.ORANGE);
		p2.setBackground(Color.green);
		//ta.setBackground(Color.blue);
		p1.setBounds(0, 0, 1920, 250);
		js.setBounds(100,280,900,700);
		tf.setBounds(100, 985,900,40);
		
		p2.setBounds(1050,280,770, 600);
		back.setBounds(1050,900, 80, 40);
		
		back.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,20));
		add(p1);
		add(js);
		add(tf);
		add(p2);
		add(back);
	}
}
