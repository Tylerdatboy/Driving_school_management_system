package com.entity.model;

import com.entity.JiaxiaobaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Registration for Driving School
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public class JiaxiaobaomingModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * contact information
	 */
	
	private String lianxifangshi;
		
	/**
	 * tuition fee
	 */
	
	private Float xuefei;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * Driving school address
	 */
	
	private String jiaxiaodizhi;
				
	
	/**
	 * 设置：contact information
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：contact information
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
				
	
	/**
	 * 设置：tuition fee
	 */
	 
	public void setXuefei(Float xuefei) {
		this.xuefei = xuefei;
	}
	
	/**
	 * 获取：tuition fee
	 */
	public Float getXuefei() {
		return xuefei;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：Driving school address
	 */
	 
	public void setJiaxiaodizhi(String jiaxiaodizhi) {
		this.jiaxiaodizhi = jiaxiaodizhi;
	}
	
	/**
	 * 获取：Driving school address
	 */
	public String getJiaxiaodizhi() {
		return jiaxiaodizhi;
	}
			
}
