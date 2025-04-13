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
 * Driving school coach
 * 数据库通用operate实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
@TableName("jiaxiaojiaolian")
public class JiaxiaojiaolianEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiaxiaojiaolianEntity() {
		
	}
	
	public JiaxiaojiaolianEntity(T t) {
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
