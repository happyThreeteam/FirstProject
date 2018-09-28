package com.sist.project;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.sist.list.FoodHouseVO;

import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Mypage extends JPanel {
	//JPanel p1=new JPanel();
	JLabel id = new JLabel("æ∆¿Ãµ ");
	JLabel id_answer=new JLabel("");
	JLabel pwd=new JLabel("∫Òπ–π¯»£ ");
	JLabel pwd_answer=new JLabel(""); 
	JLabel sex=new JLabel("º∫∫∞ ");
	JLabel sex_answer=new JLabel("");
	JLabel enjoy=new JLabel("¡Ò∞‹√£±‚");
	JPanel p2=new JPanel(); //¡Ò∞‹√£±‚
	
	JLabel la=new JLabel(); //¡Ò∞‹√£±‚ title
	JLabel la2=new JLabel(); //¡Ò∞‹√£±‚ poster
	JLabel title;
	JButton ch=new JButton("∫Ø∞Ê");
	JButton b1=new JButton("»Æ¿Œ");
	
	JTable table1, table2;
	DefaultTableModel model1, model2;  
	 
	Mypage() 
	{
		//p1.setBackground(Color.ORANGE);
		
		
		id.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,20));
		id_answer.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,20));
		pwd.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,20));
		pwd_answer.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,20));
		sex.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,20));		
		sex_answer.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,20));
		enjoy.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,20));
		//p2.setBackground(Color.orange);
		p2.setBorder(new LineBorder(Color.BLACK));
		b1.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,20));
		setLayout(null);
		
		ch.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,10));
		
		
		//p1.setBounds(0, 0, 1920, 250);
		p2.setBounds(400, 490, 1200, 365);
		id.setBounds(400, 280, 80, 100);
		id_answer.setBounds(580,280,80,100);
		pwd.setBounds(400, 320, 100, 100);
		pwd_answer.setBounds(580,320,80,100);
		
		ch.setBounds(680, 355, 60, 30);
		
		sex.setBounds(400, 360, 80, 100);
		sex_answer.setBounds(580,360,80,100);
		enjoy.setBounds(400, 400, 80, 100);
		b1.setBounds(400, 905, 80, 40);
		
		/*la.setBounds(200, 490, 100, 50);
		la2.setBounds(200, 580, 400, 350);*/
		la.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.PLAIN,20));
		title=new JLabel("GOOD TASTE");
		title.setForeground(Color.ORANGE);
	    title.setBounds(765, 10, 400, 200);
	    title.setFont(new Font("Rockwell Extra Bold",Font.BOLD,50));
		
		//add(p1);
		add(p2);
		add(id);
		add(pwd);
		add(sex);
		add(enjoy);
		add(id_answer);
		add(pwd_answer);
		add(sex_answer);
		add(b1);
		add(ch);
		p2.add(la);
		p2.add(la2);
		add(title);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
