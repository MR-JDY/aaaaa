package cn.ideal.es.domain;

import java.util.Date;

/**
 * @author Joe
 * 2017年12月4日
 */
public class UserTest {
	private String code;  
    private String name;  
    private int age;  
    private Date date;  
  
    public Date getDate() {  
        return date;  
    }  
  
    public void setDate(Date date) {  
        this.date = date;  
    }  
  
    public UserTest(String code, String name, int age) {  
        super();  
        this.code = code;  
        this.name = name;  
        this.age = age;  
    }  
  
    public String getCode() {  
        return code;  
    }  
  
    public void setCode(String code) {  
        this.code = code;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
}
