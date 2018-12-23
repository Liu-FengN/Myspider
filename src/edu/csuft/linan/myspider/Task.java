package edu.csuft.linan.myspider;

/**
 * 定义一个可以交给线程执行的任务
 * 
 * @author admin
 *
 */
public class Task implements Runnable {
	//任务编号
	 int n;
	 
	public Task(int n) {
		super();
		this.n = n;
	}
	@Override
	public void run() {
	   //正在执行的线程的名字
	  String name=Thread.currentThread().getName(); 
	  System.out.println(name + "开始:" + n);
	  
	  //延时(放慢)
	  try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  System.out.println(name + "结束:" + n);
	}

}
