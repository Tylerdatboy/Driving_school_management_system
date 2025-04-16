package com.entity.model;

import com.entity.JiaofeixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Payment information
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public class JiaofeixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * contact information
	 */
	
	private String lianxifangshi;
		
	/**
	 * Driving school address
	 */
	
	private String jiaxiaodizhi;
		
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
	 * tuition fee
	 */
	
	private Float xuefei;
		
	/**
	 * registration time
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date baomingshijian;
		
	/**
	 * Whether to pay or not
	 */
	
	private String ispay;
				
	
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
	 * 设置：registration time
	 */
	 
	public void setBaomingshijian(Date baomingshijian) {
		this.baomingshijian = baomingshijian;
	}
	
	/**
	 * 获取：registration time
	 */
	public Date getBaomingshijian() {
		return baomingshijian;
	}
				
	
	/**
	 * 设置：Whether to pay or not
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：Whether to pay or not
	 */
	public String getIspay() {
		return ispay;
	}
			
}
