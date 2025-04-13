package com.entity.vo;

import com.entity.JiaxiaobaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Registration for Driving School
 * 手机端接口return实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public class JiaxiaobaomingVO  implements Serializable {
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
