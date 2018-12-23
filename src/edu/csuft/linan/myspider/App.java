package edu.csuft.linan.myspider;

//import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @author admin
 *
 */

public class App {
    //	alt + /
	
	public static void main(String[] args) {
	//线形池
	//固定大小
	  ExecutorService pool=Executors.newFixedThreadPool(8);
	
	//无限(缓存)执行顺序不定
	  pool= Executors.newCachedThreadPool();
	
	//一个线程
	//pool=Executors.newSingleThreadExecutor();
	  
	 ArrayList<Film> list=new ArrayList<>();
	 String url = "https://movie.douban.com/top250?start";
     for(int i=0;i<10;i++) {
    	String path = String.format("%s=%d",url,i*25);//"%s"占位符    "%d"数字
	    pool.submit(new Myspider(path,list));
      }
     pool.shutdown();//停止
     System.out.println(pool.isTerminated());
     
     while(!pool.isTerminated()) {       //判断任务结束
    	 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
    	 //数据排序
    
        Collections.sort(list);
    	System.out.println(list.size());
    	
    	//导入数据库中
    	//myBatis/iBatis
    	try {
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("config.xml"));
			//打开会话
			SqlSession session =factory.openSession();        
		    //动态处理
		    FilmMapper mapper=(FilmMapper)session.getMapper(FilmMapper.class);           //做一个接口
		    for (Film f : list) {
			//使用注解中Insert语句存储到数据库	
			mapper.save(f);
		    }
		    
		    session.commit();
		    session.close();
		    System.out.printf("完成存储");
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
//    	//输出超链接的地址
//    	ExecutorService pool2=Executors.newFixedThreadPool(4);
//    	for(Film film : list) {
//    	//	System.out.println(film);      //输出点击目录的超链接地址
//    		System.out.println(film.url);
//    		pool2.execute(new SpiderXiangxi(film.url,list));
//    	}
//    	 pool2.shutdown();//停止
//    	
//    	//写入文件 电子表格模式
//    	String file="d:/film.csv";      //绝对路径
//    	file="film.csv";                //相对路径
//    	//排序
//    	Collections.sort(list);  //()里写规则
//    	//io
//    	try(FileWriter out=new FileWriter(file)) {//ture 代表追加的参数
//    		//写数据
//		for (Film film : list) {
//			out.write(film.toCSV());
//			
//		}	
//		System.out.println("ok");
//		} catch (Exception e) {
//		}
	}
}


