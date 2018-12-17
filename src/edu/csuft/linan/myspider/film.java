package edu.csuft.linan.myspider;

/**
 * 
 * @author admin
 *
 */

public class film {
	
	/**
	 * 排名
	 */
	  int id;
   /**
    * 影片名称
    */
	String title;
	
	/**
	 *相关信息
	 */
	String info;
	
	/**
	 *评分
	 */
	double rating;
	
	/**
	 *评分人数
	 */
	int num;
	/**
	 * 海报
	 */
    String poster;
    
    /**
     * 评价
     */
    String quote;

	@Override
	public String toString() {
		return "film [id=" + id + ",title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num
				+ ", poster=" + poster + ", quote=" + quote + "]";
	}
}
