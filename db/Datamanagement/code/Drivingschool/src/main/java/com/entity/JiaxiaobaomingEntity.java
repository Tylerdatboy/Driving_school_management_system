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
 * Registration for Driving School
 * 数据库通用operate实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
@TableName("jiaxiaobaoming")
public class JiaxiaobaomingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiaxiaobaomingEntity() {
		
	}
	
	public JiaxiaobaomingEntity(T t) {
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
	 * Name of driving school
	 */
					
	private String jiaxiaomingcheng;
	
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
	 * 设置：Name of driving school
	 */
	public void setJiaxiaomingcheng(String jiaxiaomingcheng) {
		this.jiaxiaomingcheng = jiaxiaomingcheng;
	}
	/**
	 * 获取：Name of driving school
	 */
	public String getJiaxiaomingcheng() {
		return jiaxiaomingcheng;
	}
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
