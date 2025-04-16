package com.entity.model;

import com.entity.XueyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * student
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public class XueyuanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * password
	 */
	
	private String mima;
		
	/**
	 * Student name
	 */
	
	private String xueyuanxingming;
		
	/**
	 * gender
	 */
	
	private String xingbie;
		
	/**
	 * Student mobile phone
	 */
	
	private String xueyuanshouji;
		
	/**
	 * ID
	 */
	
	private String shenfenzheng;
		
	/**
	 * picture
	 */
	
	private String touxiang;
		
	/**
	 * security question
	 */
	
	private String pquestion;
		
	/**
	 * Secret Answer
	 */
	
	private String panswer;
				
	
	/**
	 * 设置：password
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：password
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置：Student name
	 */
	 
	public void setXueyuanxingming(String xueyuanxingming) {
		this.xueyuanxingming = xueyuanxingming;
	}
	
	/**
	 * 获取：Student name
	 */
	public String getXueyuanxingming() {
		return xueyuanxingming;
	}
				
	
	/**
	 * 设置：gender
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：gender
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：Student mobile phone
	 */
	 
	public void setXueyuanshouji(String xueyuanshouji) {
		this.xueyuanshouji = xueyuanshouji;
	}
	
	/**
	 * 获取：Student mobile phone
	 */
	public String getXueyuanshouji() {
		return xueyuanshouji;
	}
				
	
	/**
	 * 设置：ID
	 */
	 
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	
	/**
	 * 获取：ID
	 */
	public String getShenfenzheng() {
		return shenfenzheng;
	}
				
	
	/**
	 * 设置：picture
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：picture
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：security question
	 */
	 
	public void setPquestion(String pquestion) {
		this.pquestion = pquestion;
	}
	
	/**
	 * 获取：security question
	 */
	public String getPquestion() {
		return pquestion;
	}
				
	
	/**
	 * 设置：Secret Answer
	 */
	 
	public void setPanswer(String panswer) {
		this.panswer = panswer;
	}
	
	/**
	 * 获取：Secret Answer
	 */
	public String getPanswer() {
		return panswer;
	}
			
}
