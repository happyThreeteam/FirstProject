package com.sist.project;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sist.list.CategoryVO;
import com.sist.list.FoodData1;
import com.sist.list.FoodHouseVO;

public class sub_p4_small extends JPanel{
	int curpage=1;
	
	JLabel la=new JLabel(""); // 이미지
    JLabel la1,la2,la3,la4; //이름,평점,주소,종류
    JButton bu5;

    //ArrayList<CategoryVO> list=new ArrayList<CategoryVO>();
	public sub_p4_small(){
		
		la=new JLabel();
		la1=new JLabel();
		
		
		la2=new JLabel();
		
		
		la3=new JLabel();
		
		
		la4=new JLabel();
		 bu5=new JButton("상세보기");

		
		setLayout(null);
		
		la.setBounds(50, 55, 150, 200);
	       la1.setBounds(220, 55, 300, 30);
	       
	       la2.setBounds(220, 95, 300, 30);
	       la3.setBounds(220, 135, 300, 30);
	       la4.setBounds(220, 175, 300, 30);
	       bu5.setBounds(220, 215, 100, 30);

    	add(la);
    	add(la1);
    	add(la2);
    	add(la3);
    	add(la4);
    	add(bu5);
    	
	}
	public void sub_print(CategoryVO vo)
	{
		try
    	{
    		URL url=new URL(vo.getPoster());
    		Image img=getImageSizeChange(new ImageIcon(url), 300, 250);
    		la.setIcon(new ImageIcon(img));
    	}catch(Exception ex){}
		la1.setText(vo.getTitle());
		la2.setText(vo.getScore());
		la3.setText(vo.getAddr());
		la4.setText(vo.getKind());
	}
	
	public void posterAll(CategoryVO vo)
	{
		try
    	{
    		URL url=new URL(vo.getPoster());
    		Image img=getImageSizeChange(new ImageIcon(url), 300, 250);
    		la.setIcon(new ImageIcon(img));
    		System.out.println(url);
    	}catch(Exception ex){}
	}
	
    public Image getImageSizeChange(ImageIcon icon,int width,int height)
    {
       	Image img=icon.getImage();
       	Image change=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
       	return change;
    }
	
    
}
