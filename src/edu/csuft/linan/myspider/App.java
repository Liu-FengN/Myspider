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
				Element t = e.select(".title").first();
				String num=e.select(".star span").last().text();
			    String removeNum="人评价";
				System.out.println(t.text()+","+ num.replace(removeNum, ""));
//				f.id
//				f.title
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