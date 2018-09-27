package com.sist.project;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.*;

import com.sist.list.CategoryVO;
import com.sist.list.FoodDetail1;
import com.sist.list.FoodHouseVO;


public class DetailForm_p2 extends JPanel{
	int curpage=1;
	JLabel la;
	DetailForm_p2_small[] sps=new DetailForm_p2_small[20];
	ArrayList<FoodHouseVO> list=new ArrayList<FoodHouseVO>();
	public DetailForm_p2() {
		try {
    		list=FoodDetail1.FoodAllData(1);
    		setLayout(null);
    		for(int i=0; i<list.size(); i++)
    		{
    			sps[i]=new DetailForm_p2_small();
    			sps[i].sub_print(list.get(i));
    			add(sps[i]);
    		}
    	}catch(Exception ex) {}
		
	}
	 public void DetailForm_p2_print(int page)
	 {
	    	
	    	try {
	    		   
	    		   for(int i=0; i<10; i++)
	       		{
	    			sps[i].sub_print(list.get(i));
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
