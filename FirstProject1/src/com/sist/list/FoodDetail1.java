package com.sist.list;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FoodDetail1 {
	 private static ArrayList<FoodHouseVO> detail=new ArrayList<FoodHouseVO>();
	static
	  {
	      try
	      {
	         FileInputStream fr=new FileInputStream("c:\\data\\세부사항.txt");
	         BufferedReader br=new BufferedReader(new InputStreamReader(fr));
	         while(true)
	         {
	            String str=br.readLine();
	            System.out.println(str);
	            if(str==null)
	               break;
	           try
	            {
	               StringTokenizer st=new StringTokenizer(str, "^");
	               FoodHouseVO vo=new FoodHouseVO();
	               vo.setCateplace(Integer.parseInt(st.nextToken()));
	               vo.setCateNo(Integer.parseInt(st.nextToken()));
	               vo.setTitle(st.nextToken());
	                vo.setAddr(st.nextToken());
	                
	                vo.setPrice(st.nextToken());
	                
	                vo.setKind(st.nextToken());
	                
	                vo.setHour(st.nextToken());
	                vo.setPoster(st.nextToken());
	         
	               vo.setCar(st.nextToken());
	                vo.setReview(st.nextToken());
	               // vo.setLink(st.nextToken());
	                detail.add(vo);
	            }catch(Exception ex){
	               System.out.println("Data:"+ex.getMessage());
	            }
	            
	         
	           
	         }
	      }catch(Exception ex)
	      {
	         //System.out.println(ex.getMessage());
	      }
	  }
	 public static ArrayList<FoodHouseVO> FoodAllData(int page)
	  {
	      ArrayList<FoodHouseVO> list=new ArrayList<FoodHouseVO>();
	      int j=0;//10
	      int rowSize=20;
	      int start=(page*rowSize)-rowSize;
	      
	           /*1page   0~9  => 
	           2page  10~19
	           3page  20~29*/
	       
	      int end=page*rowSize;
	      // 403  ==> 40 => 41   ==> 400 ==> 403
	      int t=(int)(Math.ceil(detail.size()/10.0));
	      if(page==t)
	      {
	         end=detail.size()-1;
	      }
	      for(int i=start;i<end;i++)
	      {
	    	  FoodHouseVO vo=detail.get(i);
	         list.add(vo);
	      }
	      return list;
	  }
	 public static FoodHouseVO FoodDetail(String title)               // 포스터 클릭시 디테일
	  {
		 FoodHouseVO mData=new FoodHouseVO();
		 //Manager fm=new Manager();
	      for(FoodHouseVO fvo:detail)
	      {
	         if(fvo.getTitle().trim().contains(title.trim()))
	         {
	            mData=fvo;
	            break;
	         }
	      }
	      return mData;
	  }
	 public static ArrayList<FoodHouseVO> FoodList(String find)
	  {
	      ArrayList<FoodHouseVO> list=new ArrayList<FoodHouseVO>();
	      try
	      {
	         String data=Manager.FoodList(find);
	         String[] datas=data.split("^");
	         Pattern[] p=new Pattern[detail.size()];
	         for(int i=0;i<p.length;i++)
	         {
	            p[i]=Pattern.compile(detail.get(i).getTitle());
	         }
	         Matcher[] m=new Matcher[detail.size()];
	         int[] count=new int[detail.size()];
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
	         
	         for(int i=0;i<detail.size();i++)
	         {
	            if(count[i]>1 && detail.get(i).getTitle().length()>1)
	            {
	               System.out.println(detail.get(i).getTitle()+" "+count[i]);
	               FoodHouseVO vo=FoodDetail(detail.get(i).getTitle());
	               list.add(vo);
	            }
	         }
	         
	      }catch(Exception ex)
	      {
	         //System.out.println(ex.getMessage());
	      }
	      return list;
	  }
}
