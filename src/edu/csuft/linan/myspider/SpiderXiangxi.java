package edu.csuft.linan.myspider;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SpiderXiangxi implements Runnable {
	
	
	String url;
	
	List<Film> list;
	//添加一个构造器
	
	
	@Override
	public void run() {
		
		try {
			Document d=Jsoup.connect(url).get();
			
            Element e=d.getElementById("content");
			
			String name=e.selectFirst("h1 span").text();
			
			String year=e.selectFirst(".year").text();
			
			String director=e.selectFirst("#info .attrs").selectFirst("a").text();
		  //String script=e.select("#info span").get(2).selectFirst(".attrs a").text();
			String script=e.select("#info .attrs").get(1).text();
			String actor=e.selectFirst(".actor .attrs").text();
			
			
			//打印输出
			System.out.printf("%s,%s,%s,%s,%s\n",
					name,
					year,
					director,
					script,
					actor
					);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public SpiderXiangxi(String url, List<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}

}
