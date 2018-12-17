package edu.csuft.linan.myspider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author admin
 *
 */

public class App {
    //	alt + /
	
	public static void main(String[] args) {
    //目标url
		String url="http://movie.douban.com/top250";
		
    //使用JSOUP 抓取文档
		try {
			Document doc=Jsoup.connect(url).get();
	//select()函数筛选数据  //Elements es=doc.select(".grid_view img");
			Elements es=doc.select(".grid_view .item");//在有类选择器里进行查找，加“.”
     		System.out.println(es.size());
			//创建一个影片的列表
			 ArrayList<film>list=new ArrayList<>();
			for(Element e:es)
			{
			//System.out.println(e.attr("src")); //"src"代表直接获取图片地址
			   film f=new film();
				//每一部影片
			   f.id=Integer.parseInt(e.select(".pic em").first().text());
			   f.poster=e.select("img").first().attr("src");
			   f.info=e.select(".bd p").first().text();
			   f.title=e.select(".title").first().text();
			   f.rating=Double.parseDouble(e.select(".rating_num").first().text());
			   String num=e.select(".star span").last().text();
			   f.num=Integer.parseInt(num.substring(0,num.length()-3));
			   f.quote=e.select(".inq").first().text();
			   
			   System.out.println(f);
               list.add(f);			
				
			}
		   //直接定义获取数据
		   /*String title=doc.title();
		     String html=doc.html();
             String data=doc.data();
			
             System.out.println(title);
		     System.out.println(html);
             System.out.println(data);
			*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
