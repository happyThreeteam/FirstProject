package com.sist.project;

import javax.swing.*;

import com.sist.list.CategoryVO;
import com.sist.list.FoodData1;
import com.sist.list.FoodDetail1;
import com.sist.list.FoodHouseVO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.*;

public class sub1_p4 extends JPanel {
	int curpage=1;
	JLabel la=new JLabel("");
	
    sub_p4_small[] sps=new sub_p4_small[20];
    ArrayList<CategoryVO> list=new ArrayList<CategoryVO>();
    public sub1_p4() {
    	try {
            list=FoodData1.FoodAllData(1);
            setLayout(null);
            int k=0;
            for(int i=0; i<list.size(); i++)
            {
               
               sps[i]=new sub_p4_small();
               sps[i].sub_print(list.get(i));
               /*if(i==5)
               {
                  k=0;
               }
               if(i<5)
               {
                  sps[i].setBounds(10+(k*320), 15, 545, 350);
               }
               else
               {
                  sps[i].setBounds(10+(k*320), 300, 545, 350);
               }*/
               if(i==5) {
                  k=0;
               }
               if(i<5)
               {
                  sps[i].setBounds((k*384), 0, 384, 310);
               }
               else
               {
                  sps[i].setBounds((k*384), 310, 384, 310);
               }
               add(sps[i]);
               k++;
               
            }
            
         }catch(Exception ex) {}
    }

    public void sub1_p4_print(ArrayList<CategoryVO> list,int page)
    {
    	
    	try {
    		
    		for(int i=0; i<list.size(); i++)
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