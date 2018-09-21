package com.sist.list;
import java.io.*;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Manager {
   public ArrayList<CategoryVO> categoryAllData()
    {
      ArrayList<CategoryVO> list=new ArrayList<CategoryVO>();
      String[] catelink = {"http://www.mangoplate.com/search/%EA%B0%95%EB%82%A8%EA%B5%AC?keyword=%EA%B0%95%EB%82%A8%EA%B5%AC&page=",
    		  "http://www.mangoplate.com/search/%EB%A7%88%ED%8F%AC%EA%B5%AC?keyword=%EB%A7%88%ED%8F%AC%EA%B5%AC&page=",
    		  "http://www.mangoplate.com/search/%EC%86%8D%EC%B4%88%EC%8B%9C?keyword=%EC%86%8D%EC%B4%88%EC%8B%9C&page=",
    		  "http://www.mangoplate.com/search/%EA%B0%95%EB%A6%89%EC%8B%9C?keyword=%EA%B0%95%EB%A6%89%EC%8B%9C&page="}; //강남,마포,속초,강릉
      
         for(int c=0; c<catelink.length;c++) {
		      for(int k=1;k<=10;k++)
		          {
		             try
		             {
		                Document doc=Jsoup.connect(catelink[c]+k).get();
		                Elements poster=doc.select("img.center-croping");
		                Elements title=doc.select("div.info h2.title");
		                Elements score=doc.select("div.info strong");
		                Elements addr=doc.select("p.etc");
		                Elements kind=doc.select("p.etc");
		                Elements link=doc.select("ul.list-restaurants li a.only-desktop_not");
		                
		                for(int i=0; i<poster.size(); i++)
		               {
		                   System.out.println("포스터 : "+poster.get(i).attr("data-original"));
		                   System.out.println("가게이름 : "+title.get(i).text());
		                   System.out.println("평점 : "+score.get(i).text());
		                   System.out.println("위치 : "+addr.get(i).text());
		                   System.out.println("종류 : "+kind.get(i).text());
		                   System.out.println("링크 : "+link.get(i).attr("href"));
		                     
		                   CategoryVO vo=new CategoryVO(); 
		                   vo.setCateplace(c+1);
		                   vo.setCateNo(i+1);
		                   vo.setPoster(poster.get(i).attr("data-original"));
		                   vo.setTitle(title.get(i).text());
		                   vo.setScore(score.get(i).text());
		                   vo.setAddr(addr.get(i).text());
		                   vo.setKind(kind.get(i).text());
		                   vo.setLink(link.get(i).attr("href"));
		                   list.add(vo);
		               }
		
		             }catch(Exception e)
		             {
		                
		             }
		          }
         }
		return list;
    }
   public ArrayList<FoodHouseVO> foodAllData()
   {
	   ArrayList<FoodHouseVO> list=new ArrayList<FoodHouseVO>();
	      
	      try
	      {
	    	  ArrayList<CategoryVO> cList=categoryAllData();
	          for(int i=0;i<cList.size();i++)
	          {
	             CategoryVO vo=cList.get(i);
	             Document doc=Jsoup.connect("http://www.mangoplate.com/"+vo.getLink()).get();
	             Elements link=doc.select("main");
	             for(int j=0;j<10;j++)
	             {
	                try
	                {
	                   
	                   //System.out.println(link.get(j).attr("href"));
	                   //String food="http://www.mangoplate.com"+link.get(j).attr("data-url");
	                   Document doc2=Jsoup.connect("http://www.mangoplate.com/restaurants/"+link.get(j).attr("data-restaurant_key")).get();
	                   Element title=doc2.selectFirst("span.title h1.restaurant_name");
	                   Element addr=doc2.select("table.info tr td").get(0);
	                   Element price=doc2.select("table.info tr td").get(3);
	                   Element kind=doc2.select("table.info tr td").get(2);
	                   Element hour=doc2.select("table.info tr td").get(5);
	                   Element car=doc2.select("table.info tr td").get(4);
	                   Element review=doc2.select("div.review_wraper span").get(0);
	                   Element poster=doc2.selectFirst("img.center-croping");
	                   
	                   System.out.println(title.text());
	                   System.out.println(addr.text());
	                   System.out.println(price.text());
	                   System.out.println(kind.text());
	                   System.out.println(hour.text());
	                   System.out.println(car.text());
	                   System.out.println(review.text());
	                   System.out.println(poster.attr("src"));
	                   
	                   FoodHouseVO fvo=new FoodHouseVO();
	                   fvo.setCateNo(vo.getCateNo());
	                   fvo.setTitle(vo.getTitle());
	                   fvo.setAddr(addr.text());
	                   fvo.setPrice(price.text());
	                   fvo.setKind(kind.text());
	                   fvo.setHour(hour.text());
	                   fvo.setCar(car.text());
	                   fvo.setReview(review.text());
	                   fvo.setPoster(poster.attr("src"));
	                   
	                   list.add(fvo);
	                   
	                }catch(Exception ex)
	                {
	                   
	                }
	             }
	             System.out.println("======================");
	          }
	       }catch(Exception ex)
	       {
	          System.out.println(ex.getMessage());
	       }
	       
	       return list;
   }
  
   // 찾기
   // Category별 찾기
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Manager fm=new Manager();
      
   
      ArrayList<CategoryVO> list=fm.categoryAllData();
      try
      {
    	  File f=new File("c:\\data\\카테고리.txt");
          if(f.exists())
             f.delete();

         FileWriter fw=new FileWriter("c:\\data\\카테고리.txt");
         for(CategoryVO vo:list)
         {
            String str=vo.getCateplace()+"^"+
            		    vo.getCateNo()+"^"
                     +vo.getPoster()+"^"
                     +vo.getTitle()+"^"
                     +vo.getScore()+"^"
                     +vo.getAddr().substring(0, vo.getAddr().lastIndexOf("-")).trim()+"^"
                     +vo.getKind().substring(vo.getAddr().lastIndexOf("-")+1).trim()+"\r\n";
                     
                           
            fw.write(str);
         }
         fw.close();
         System.out.println("Save End...");
      }catch(Exception ex) {}
   
      
      
      ArrayList<FoodHouseVO> list2=fm.foodAllData();
      try
      {
    	  File f=new File("c:\\data\\세부사항.txt");
          if(f.exists())
             f.delete();

         FileWriter fw=new FileWriter("c:\\data\\세부사항.txt"); // true없으면 덮어쓰기
         for(FoodHouseVO vo:list2)
         {
            String str=+vo.getCateplace()+"^"
            		+vo.getCateNo()+"^"
                  +vo.getTitle()+"^"
                  +vo.getAddr()+"^"
                  +vo.getPrice()+"^"
                  +vo.getKind()+"^"
                  +vo.getHour()+"^"
                  +vo.getCar()+"^"
                  +vo.getReview()+"^"
                  +vo.getPoster()+"\r\n";
            	
            fw.write(str);
         }
         fw.close();
         System.out.println("Save..");
      }catch(Exception ex) {}
   }
public static String FoodList(String find) {
	// TODO Auto-generated method stub
	return null;
}


}




