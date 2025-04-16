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
 * student
 * 数据库通用operate实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
@TableName("xueyuan")
public class XueyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XueyuanEntity() {
		
	}
	
	public XueyuanEntity(T t) {
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
	 * Student account
	 */
					
	private String xueyuanzhanghao;
	
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
