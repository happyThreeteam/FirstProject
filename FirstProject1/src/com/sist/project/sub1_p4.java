package com.sist.project;

import javax.swing.*;

import com.sist.list.CategoryVO;
import com.sist.list.FoodData1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.*;

public class sub1_p4 extends JPanel{
	int curpage=1;
	JLabel la;
	
	/*JButton button1=new JButton("이전");
	   JButton button2=new JButton("이후");*/
	   
    sub_p4_small[] sps=new sub_p4_small[10];
    ArrayList<CategoryVO> list=new ArrayList<CategoryVO>();
    public sub1_p4() {
    	try {
    		list=FoodData1.FoodAllData(1);
    		setLayout(new GridLayout(5, 2));
    		for(int i=0; i<list.size(); i++)
    		{
    			sps[i]=new sub_p4_small();
    			sps[i].sub_print(list.get(i));
    			add(sps[i]);
    		}
    	}catch(Exception ex) {}
    	
    	/*button1.setBounds(700, 990, 50, 30);
        button2.setBounds(780, 990, 50, 30);
       button1.setOpaque(false);
       button2.setOpaque(false);
         add(button1);
	     add(button2);*/
    /*button1.addActionListener(this);
    button2.addActionListener(this);*/
    }
    public void getFoodView()
    {
    	  sub1_p4_print(curpage);
    }

    public void sub1_p4_print(int page)
    {
    	
    	try {
    		list=FoodData1.FoodAllData(page);
    		//setLayout(new GridLayout(5, 2));
    		//System.out.println(list.size());
    		for(int i=0; i<list.size(); i++)
    		{
    			//sps[i].removeAll();
    			sps[i].sub_print(list.get(i));
    			//sps[i].validate();
    			//add(sps[i]);
    		}
    	}catch(Exception ex) {}
    }

    
    public Image getImageSizeChange(ImageIcon icon,int width,int height)
    {
    	Image img=icon.getImage();
    	Image change=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    	return change;
    }
    
	
	
}