package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * Appointment Practice
 * 数据库通用operate实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
@TableName("yuyuelianxi")
public class YuyuelianxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YuyuelianxiEntity() {
		
	}
	
	public YuyuelianxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * Coach account
	 */
					
	private String jiaolianzhanghao;
	
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
	 * time of appointment
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date yuyueshijian;
	
	/**
	 * Appointment remarks
	 */
					
	private String yuyuebeizhu;
	
	/**
	 * Practice subjects
	 */
					
	private String lianxikemu;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * Review reply
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：Coach account
	 */
	public void setJiaolianzhanghao(String jiaolianzhanghao) {
		this.jiaolianzhanghao = jiaolianzhanghao;
	}
	/**
	 * 获取：Coach account
	 */
	public String getJiaolianzhanghao() {
		return jiaolianzhanghao;
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
	 * 设置：time of appointment
	 */
	public void setYuyueshijian(Date yuyueshijian) {
		this.yuyueshijian = yuyueshijian;
	}
	/**
	 * 获取：time of appointment
	 */
	public Date getYuyueshijian() {
		return yuyueshijian;
	}
	/**
	 * 设置：Appointment remarks
	 */
	public void setYuyuebeizhu(String yuyuebeizhu) {
		this.yuyuebeizhu = yuyuebeizhu;
	}
	/**
	 * 获取：Appointment remarks
	 */
	public String getYuyuebeizhu() {
		return yuyuebeizhu;
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
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：Review reply
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：Review reply
	 */
	public String getShhf() {
		return shhf;
	}

}
