package com.sist.project;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class sub1Frame extends JPanel{
	JPanel p1 = new JPanel();
	JComboBox p2 ;
	JComboBox p3 ;
	JPanel p4 = new JPanel(); 
	
	
	
	JTextField tf; 
	JButton b;  // 검색버튼
	JButton d;  // 콤보박스 버튼
	
	Image pan1;
	 
	String 업종[]= {"업종 선택","중식", "한식", "일식","양식"};
	String 가격[] = {"가격 선택","~5천", "5천~1만", "1만~2만", "2만~3만", "3만~4만", "4만~5만","5만~"};
	
	public sub1Frame(){
		
		 
		
		tf = new JTextField();	
	    b = new JButton("검색");
	    d = new JButton("검색");
	    p4.setBackground(Color.RED);
	    
	    
		setLayout(null);
		
		p2 = new JComboBox<String>(업종);
		p3 = new JComboBox<String>(가격);
		
		
		p1.setBounds(0, 310, 1920, 60);
		p2.setBounds(860, 327, 100, 20);
		p3.setBounds(960, 327, 100, 20);
		tf.setBounds(540,250,800,35);
		b.setBounds(1345,242,50,50);
		d.setBounds(1065, 315, 50 ,50);
		p4.setBounds(0, 370, 1920, 2000);
	
	    
		add(p2, BorderLayout.NORTH);
		add(p3, BorderLayout.NORTH);
		
	    
		add(tf);
		add(b);
		add(d);
		add(p1);
		add(p4);
	
		
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	   protected void paintComponent(Graphics g) {
	      g.drawImage(pan1,0,0,1920,310, this);
	   }


}

