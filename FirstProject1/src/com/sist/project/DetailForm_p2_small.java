package com.sist.project;
import javax.swing.*;

import com.sist.list.CategoryVO;
import com.sist.list.FoodHouseVO;

import java.awt.*;
import java.net.URL;

public class DetailForm_p2_small extends JPanel{
	JLabel la;
	JLabel la1,la2,la3,la4,la5,la6,la7,la8;
	
	public DetailForm_p2_small() {
		la=new JLabel(); //Æ÷½ºÅÍ
		la1=new JLabel(); //title
		la2=new JLabel(); //addr
		la3=new JLabel(); //price
		la4=new JLabel(); //hour
		la5=new JLabel(); //kind
		la6=new JLabel(); //
		la7=new JLabel(); //car
		la8=new JLabel(); //review+review2
		
		setLayout(null);
		 //p2.setBounds(0, 315, 1400, 650);
		la.setBounds(100, 50, 500, 500);
		la1.setBounds(500, 150, 200, 40);
		la2.setBounds(500, 220, 400, 40);
		la3.setBounds(500, 290, 200, 40);
		la4.setBounds(500, 360, 200, 40);
		la5.setBounds(500, 430, 200, 40);
		la6.setBounds(500, 500, 400, 40);
		la7.setBounds(500, 570, 800, 80);
		
		la1.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,30));
		la2.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,20));
		la3.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,20));
		la4.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,20));
		la5.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,20));
		la6.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,20));
		la7.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,20));
		//la6.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,20));
		/*la2.setBounds(r);
		la3.setBounds(r);
		la4.setBounds(r);
		la5.setBounds(r);
		la6.setBounds(r);
		la7.setBounds(r);
		la8.setBounds(r);*/
		
		add(la);
		add(la1);
		add(la2);
		add(la3);
		add(la4);
		add(la5);
		add(la6);
		add(la7);
	}
	public void sub_print(FoodHouseVO vo)
	{
		try
    	{
    		URL url=new URL(vo.getPoster());
    		Image img=getImageSizeChange(new ImageIcon(url), 300, 250);
    		la.setIcon(new ImageIcon(img));
    	}catch(Exception ex){}
		la1.setText(vo.getTitle());
		la2.setText(vo.getAddr());
		la3.setText(vo.getPrice());
		la4.setText(vo.getKind());
		la5.setText(vo.getHour());
		la6.setText(vo.getCar());
		la7.setText(vo.getReview());
	}
    public Image getImageSizeChange(ImageIcon icon,int width,int height)
    {
       	Image img=icon.getImage();
       	Image change=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
       	return change;
    }
}
