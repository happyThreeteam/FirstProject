package com.sist.project;

import javax.swing.*;
import java.awt.*;
import java.awt.color.*;

public class sub2Frame extends JPanel{
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	
	
	JTextField tf;
	JButton b;
	JButton back;
	JLabel title;
	
	
	public sub2Frame(){
		p1.setBackground(Color.BLUE);
		p2.setBackground(Color.RED);
		
		tf = new JTextField();
	    b = new JButton("검색");
	    back=new JButton("이전");
	    title=new JLabel("GOOD TASTE");
	    
		setLayout(null);
		
		
		
		
		p1.setBounds(0, 0, 1920, 310);
		p2.setBounds(0, 310, 1920, 2000);
		
		tf.setBounds(540,250,800,35);
		b.setBounds(1345,242,50,50);
		back.setBounds(1400, 242, 50, 50);
		
		title.setForeground(Color.ORANGE);
		title.setBounds(765, 10, 350, 200);
		title.setFont(new Font("Rockwell Extra Bold",Font.BOLD,40));
	
	    
		
		add(title);
		add(tf);
		add(b);
		add(back);
		
		add(p1);
		add(p2);
	
		
		
	
		
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

