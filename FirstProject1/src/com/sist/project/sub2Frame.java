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
	JButton mpb;
	
	public sub2Frame(){
		//p1.setBackground(Color.BLUE);
		//p2.setBackground(Color.RED);
		mpb = new JButton("마이페이지");
		tf = new JTextField();
	    b = new JButton("검색");
	    back=new JButton("이전");
	    
		setLayout(null);
		
		
		
		
		p1.setBounds(0, 0, 1920, 310);
		p2.setBounds(0, 310, 1920, 2000);
		
		tf.setBounds(540,250,800,35);
		b.setBounds(1345,242,50,50);
		back.setBounds(1400, 242, 50, 50);
		
		title=new JLabel("GOOD TASTE");
		title.setForeground(Color.ORANGE);
	      title.setBounds(765, 10, 400, 200);
	      title.setFont(new Font("Rockwell Extra Bold",Font.BOLD,50));
		mpb.setBounds(1780,10,100,40);
		mpb.setOpaque(true);
		
		add(title);
		add(tf);
		add(b);
		add(back);
		
		add(p1);
		add(p2);
	
		add(mpb);
		
	
		
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

