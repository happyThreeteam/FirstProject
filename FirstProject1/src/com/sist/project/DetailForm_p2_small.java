package com.sist.project;
import javax.swing.*;

import com.sist.list.CategoryVO;
import com.sist.list.FoodHouseVO;

import java.awt.*;
import java.net.URL;

public class DetailForm_p2_small extends JPanel{
	JLabel la;
	JLabel la1,la2,la3,la4,la5,la6;
	JLabel title;
	public DetailForm_p2_small() {
		la=new JLabel(); //Æ÷½ºÅÍ
		la1=new JLabel(); //title
		la2=new JLabel(); //addr
		la3=new JLabel(); //price
		la4=new JLabel(); //hour
		la5=new JLabel(); //kind
		la6=new JLabel(); //
		setLayout(null);
		la.setBounds(100, 50, 500, 500);
		la1.setBounds(100, 90, 400, 40);
		la2.setBounds(500, 170, 400, 40);
		la3.setBounds(500, 240, 400, 40);
		la4.setBounds(500, 310, 400, 40);
		la5.setBounds(500, 380, 400, 40);
		la6.setBounds(500, 450, 400, 40);
		la1.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,30));
		la2.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,20));
		la3.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,20));
		la4.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,20));
		la5.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,20));
		la6.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,20));
		
	      
		add(la);
		add(la1);
		add(la2);
		add(la3);
		add(la4);
		add(la5);
		add(la6);
		//add(title);
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
		la2.setText("ÁÖ ¼Ò : "+vo.getAddr());
		la3.setText("°¡ °Ý : "+vo.getPrice());
		la4.setText("Á¾ ·ù : "+vo.getKind());
		la5.setText("½Ã °£ : "+vo.getHour());
		la6.setText("ÁÖ Â÷ : "+vo.getCar());
	}
    public Image getImageSizeChange(ImageIcon icon,int width,int height)
    {
       	Image img=icon.getImage();
       	Image change=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
       	return change;
    }
}
