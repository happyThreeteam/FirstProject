package com.sist.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SearchBarForm extends JPanel {
	CardLayout card=new CardLayout();
	JPanel p1=new JPanel();
	//JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	JPanel p5=new JPanel();
	 
	JButton b;
	public JButton mpb;
	public JButton chat;
	
	JTextField tf;
	JLabel title;
	Image map;
	
	//JLabel 
	
	
	public SearchBarForm() {
		p1.setBackground(Color.blue); 
		//p2.setBackground(Color.white);
		p3.setBackground(Color.RED);
		p4.setBackground(Color.orange);
		p5.setBackground(Color.green);
		
		  // 로고 
		  title=new JLabel("GOOD TASTE");
	      // 검색창 
	      tf = new JTextField();
	      // 검색 버튼
	      b = new JButton("검색");
	      // 마이페이지 버튼
	      mpb = new JButton("마이페이지");
	      chat=new JButton("채팅창");
	      
		setLayout(null);
		
		map=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\map.png");
		p1.setBounds(0,0,1920,310);
		//p2.setBounds(0,310,810,520);
		p3.setBounds(810,310,810,520);
		p4.setBounds(1620,310,300,770);
		p5.setBounds(0,830,1620,250);
		
		tf.setBounds(540,250,800,35);
		b.setBounds(1345,242,50,50);
		
		mpb.setBounds(1690,10,100,40);
		chat.setBounds(1800,10,100,40);
		
		title.setForeground(Color.ORANGE);
		title.setBounds(765, 10, 350, 200);
		title.setFont(new Font("Rockwell Extra Bold",Font.BOLD,40));
		
		add(chat);
		add(title);
		add(tf);
	    add(b);
	    add(mpb);
		add(p1);
		//add(p2);
		add(p3);
		add(p4);
		add(p5);
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(map,0,310,810,520, this);
	}
}

