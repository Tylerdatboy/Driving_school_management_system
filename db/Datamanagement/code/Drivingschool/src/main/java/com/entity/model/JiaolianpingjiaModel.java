package com.entity.model;

import com.entity.JiaolianpingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * coach evaluate
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public class JiaolianpingjiaModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * Coach Name
	 */
	
	private String jiaolianxingming;
		
	/**
	 * Contact Number
	 */
	
	private String lianxidianhua;
		
	/**
	 * Student account
	 */
	
	private String xueyuanzhanghao;
		
	/**
	 * Student name
	 */
	
	private String xueyuanxingming;
		
	/**
	 * Student mobile phone
	 */
	
	private String xueyuanshouji;
		
	/**
	 * Practice subjects
	 */
	
	private String lianxikemu;
		
	/**
	 *  evaluate
	 */
	
	private String pingjia;
				
	
	/**
	 * 设置：Coach Name
	 */
	 
	public void setJiaolianxingming(String jiaolianxingming) {
		this.jiaolianxingming = jiaolianxingming;
	}
	
	/**
	 * 获取：Coach Name
	 */
	public String getJiaolianxingming() {
		return jiaolianxingming;
	}
				
	
	/**
	 * 设置：Contact Number
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：Contact Number
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
				
	
	/**
	 * 设置：Student account
	 */
	 
	public void setXueyuanzhanghao(String xueyuanzhanghao) {
		this.xueyuanzhanghao = xueyuanzhanghao;
	}
	
	/**
	 * 获取：Student account
	 */
	public String getXueyuanzhanghao() {
		return xueyuanzhanghao;
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
	 * 设置：Practice subjects
	 */
	 
	public void setLianxikemu(String lianxikemu) {
		this.lianxikemu = lianxikemu;
	}
	
	/**
	 * 获取：Practice subjects
	 */
	public String getLianxikemu() {
		return lianxikemu;
	}
				
	
	/**
	 * 设置： evaluate
	 */
	 
	public void setPingjia(String pingjia) {
		this.pingjia = pingjia;
	}
	
	/**
	 * 获取： evaluate
	 */
	public String getPingjia() {
		return pingjia;
	}
			
}
