package com.sist.list;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.naming.spi.NamingManager;
import com.sist.list.*;

public class FoodData1 {
  private static ArrayList<CategoryVO> gangnam=new ArrayList<CategoryVO>();
  static
  {
      try
      {
         FileInputStream fr=new FileInputStream("c:\\data\\강남카테고리.txt");
         BufferedReader br=new BufferedReader(new InputStreamReader(fr));
         while(true)
         {
            String str=br.readLine();
            System.out.println(str);
            if(str==null)
               break;
           try
            {
             // System.out.println(2);
               StringTokenizer st=new StringTokenizer(str, "^");
               CategoryVO vo=new CategoryVO();
               vo.setCateNo(Integer.parseInt(st.nextToken()));
              vo.setPoster(st.nextToken());
               vo.setTitle(st.nextToken());
                vo.setScore(st.nextToken());
                vo.setAddr(st.nextToken());
                vo.setKind(st.nextToken());
                gangnam.add(vo);
                System.out.println(vo.getKind());
            }catch(Exception ex){
               //System.out.println(ex.getMessage());
            }
            
         
           
         }
      }catch(Exception ex)
      {
         //System.out.println(ex.getMessage());
      }
  }
  public static ArrayList<CategoryVO> FoodAllData(int page)
  {
      ArrayList<CategoryVO> list=new ArrayList<CategoryVO>();
      int j=0;//10
      int rowSize=10;
      int start=(page*rowSize)-rowSize;
      /*
       *    1page   0~9  => 
       *    2page  10~19
       *    3page  20~29
       */
      int end=page*rowSize;
      // 403  ==> 40 => 41   ==> 400 ==> 403
      int t=(int)(Math.ceil(gangnam.size()/10.0));
      if(page==t)
      {
         end=gangnam.size()-1;
      }
      for(int i=start;i<end;i++)
      {
         CategoryVO vo=gangnam.get(i);
         list.add(vo);
      }
      return list;
  }
  public static CategoryVO FoodDetail(String title)
  {
     CategoryVO mData=new CategoryVO();
      for(CategoryVO vo:gangnam)
      {
         if(vo.getTitle().equals(title))
         {
            mData=vo;
            break;
         }
      }
      return mData;
  }
  public static ArrayList<CategoryVO> FoodList(String find)
  {
      ArrayList<CategoryVO> list=new ArrayList<CategoryVO>();
      try
      {
         String data=ManagerGangnam.FoodList(find);
         String[] datas=data.split("|");
         Pattern[] p=new Pattern[gangnam.size()];
         for(int i=0;i<p.length;i++)
         {
            p[i]=Pattern.compile(gangnam.get(i).getTitle());
         }
         Matcher[] m=new Matcher[gangnam.size()];
         int[] count=new int[gangnam.size()];
         for(String s:datas)
         {
            
            for(int i=0;i<m.length;i++)
            {
               m[i]=p[i].matcher(s);
               if(m[i].find())
               {
                  count[i]++;
               }
            }
         }
         
         for(int i=0;i<gangnam.size();i++)
         {
            if(count[i]>1 && gangnam.get(i).getTitle().length()>1)
            {
               System.out.println(gangnam.get(i).getTitle()+" "+count[i]);
               CategoryVO vo=FoodDetail(gangnam.get(i).getTitle());
               list.add(vo);
            }
         }
         
      }catch(Exception ex)
      {
         //System.out.println(ex.getMessage());
      }
      return list;
  }
  
  public static void main(String[] args) {
     
  }
}