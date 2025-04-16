package com.entity.vo;

import com.entity.FenpeijiaolianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Assign coach
 * 手机端接口return实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public class FenpeijiaolianVO  implements Serializable {
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
	 * Allocate time
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fenpeishijian;
		
	/**
	 * 跨表User id
	 */
	
	private Long crossuserid;
		
	/**
	 * 跨表主键id
	 */
	
	private Long crossrefid;
				
	
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
	 * 设置：Allocate time
	 */
	 
	public void setFenpeishijian(Date fenpeishijian) {
		this.fenpeishijian = fenpeishijian;
	}
	
	/**
	 * 获取：Allocate time
	 */
	public Date getFenpeishijian() {
		return fenpeishijian;
	}
				
	
	/**
	 * 设置：跨表User id
	 */
	 
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	
	/**
	 * 获取：跨表User id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
				
	
	/**
	 * 设置：跨表主键id
	 */
	 
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
			
}
