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
		la3=new JLabel(); //tel
		la4=new JLabel(); //price
		la5=new JLabel(); //kind
		la6=new JLabel(); //hour
		la7=new JLabel(); //car
		la8=new JLabel(); //review+review2
		
		setLayout(null);
		 //p2.setBounds(0, 315, 1400, 650);
		//la.setBounds();
		la1.setBounds(50,50,30,30);
		
		la1.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,20));
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
		add(la8);
		
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
		la3.setText(vo.getTel());
		la4.setText(vo.getPrice());
		la5.setText(vo.getKind());
		la6.setText(vo.getHour());
		la7.setText(vo.getCar());
		la8.setText(vo.getReview()+vo.getReview2());
	}
    public Image getImageSizeChange(ImageIcon icon,int width,int height)
    {
       	Image img=icon.getImage();
       	Image change=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
       	return change;
    }
}
