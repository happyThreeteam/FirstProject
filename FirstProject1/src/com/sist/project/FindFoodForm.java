package com.sist.project;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class FindFoodForm extends JPanel{
    JTable table;
    JPanel p1=new JPanel();
    JLabel title;
    JButton back;
    
    DefaultTableModel model;
    public FindFoodForm()
    {
       String[] col={"","업체명","주소"};
       Object[][] row=new Object[0][3];
       setLayout(null);
       model=new DefaultTableModel(row, col)
       {
         @Override
         public boolean isCellEditable(int row, int column) {
            // TODO Auto-generated method stub
            return false;
         }

         @Override
         public Class getColumnClass(int columnIndex) {
            // TODO Auto-generated method stub
            return getValueAt(0, columnIndex).getClass();
         }
       };
       
      
       
        
        
        back=new JButton("이전");       
       table=new JTable(model);
       table.setRowHeight(30);
       JScrollPane js=new JScrollPane(table);
       
       js.setBounds(500, 320, 800, 600);
       p1.setBounds(0,0,1920,310);
        back.setBounds(1320, 880, 50, 50);
        
        title=new JLabel("GOOD TASTE");
		title.setForeground(Color.ORANGE);
	      title.setBounds(765, 10, 400, 200);
	      title.setFont(new Font("Rockwell Extra Bold",Font.BOLD,50));
         
       add(js);
       add(back);
       add(title);
        add(p1);
       
         
    }
}