package com.entity.vo;

import com.entity.JiaxiaojiaolianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Driving school coach
 * 手机端接口return实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public class JiaxiaojiaolianVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * password
	 */
	
	private String mima;
		
	/**
	 * Coach Name
	 */
	
	private String jiaolianxingming;
		
	/**
	 * age
	 */
	
	private Integer nianling;
		
	/**
	 * gender
	 */
	
	private String xingbie;
		
	/**
	 * Length of teaching
	 */
	
	private String jiaoling;
		
	/**
	 * picture
	 */
	
	private String touxiang;
		
	/**
	 * Contact Number
	 */
	
	private String lianxidianhua;
		
	/**
	 * 个人介绍
	 */
	
	private String gerenjieshao;
		
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
	 * 设置：age
	 */
	 
	public void setNianling(Integer nianling) {
		this.nianling = nianling;
	}
	
	/**
	 * 获取：age
	 */
	public Integer getNianling() {
		return nianling;
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
	 * 设置：Length of teaching
	 */
	 
	public void setJiaoling(String jiaoling) {
		this.jiaoling = jiaoling;
	}
	
	/**
	 * 获取：Length of teaching
	 */
	public String getJiaoling() {
		return jiaoling;
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
	 * 设置：个人介绍
	 */
	 
	public void setGerenjieshao(String gerenjieshao) {
		this.gerenjieshao = gerenjieshao;
	}
	
	/**
	 * 获取：个人介绍
	 */
	public String getGerenjieshao() {
		return gerenjieshao;
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
