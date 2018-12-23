package edu.csuft.linan.myspider;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
//注解、装饰器
@Mapper
public interface FilmMapper {
	
	//映射ORM mapping
	
	@Insert("insert into film(id,title,num,rating,url,info) values(#{id},#{title},#{num},#{rating},#{url},#{info})")
  //存数据
  void save(Film film);
	
	@Select("select * from film where id=#{id}")  //“#”代表的参数
  Film load(int id);
}
 