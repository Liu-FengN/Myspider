package edu.csuft.linan.myspider;

/**
 * 
 * @author admin
 *
 */

 
public class Film implements Comparable<Film>{         //类型相同的进行比较
	
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
     * 影片详细信息
     */
    
    String url;
    
    /**
     * 评价
     */
    String quote;
  //无参的构造方法
    public Film() {
   	}
    //get、set
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String toCSV(){   //转换文本为.csv
    	return String.format("%d,%s,%d,%.1f,%s\n",
    			id,
    			title,
    			num,
    			rating,
    			quote);
    }

	
	

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title +  " ,rating=" + rating + ", num=" + num
				+ ", poster=" + poster + ", url=" + url + "]";
	}




	@Override
	public int compareTo(Film o) {
		// TODO Auto-generated method stub
		return o.id-id;    //降序排列
	}
}
