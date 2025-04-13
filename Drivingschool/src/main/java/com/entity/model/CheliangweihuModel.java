package com.entity.model;

import com.entity.CheliangweihuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Vehicle maintenance
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public class CheliangweihuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 车辆名称
	 */
	
	private String cheliangmingcheng;
		
	/**
	 * 车辆类型
	 */
	
	private String cheliangleixing;
		
	/**
	 * 维护时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date weihushijian;
		
	/**
	 * 维护内容
	 */
	
	private String weihuneirong;
		
	/**
	 * 维护结果
	 */
	
	private String weihujieguo;
				
	
	/**
	 * 设置：车辆名称
	 */
	 
	public void setCheliangmingcheng(String cheliangmingcheng) {
		this.cheliangmingcheng = cheliangmingcheng;
	}
	
	/**
	 * 获取：车辆名称
	 */
	public String getCheliangmingcheng() {
		return cheliangmingcheng;
	}
				
	
	/**
	 * 设置：车辆类型
	 */
	 
	public void setCheliangleixing(String cheliangleixing) {
		this.cheliangleixing = cheliangleixing;
	}
	
	/**
	 * 获取：车辆类型
	 */
	public String getCheliangleixing() {
		return cheliangleixing;
	}
				
	
	/**
	 * 设置：维护时间
	 */
	 
	public void setWeihushijian(Date weihushijian) {
		this.weihushijian = weihushijian;
	}
	
	/**
	 * 获取：维护时间
	 */
	public Date getWeihushijian() {
		return weihushijian;
	}
				
	
	/**
	 * 设置：维护内容
	 */
	 
	public void setWeihuneirong(String weihuneirong) {
		this.weihuneirong = weihuneirong;
	}
	
	/**
	 * 获取：维护内容
	 */
	public String getWeihuneirong() {
		return weihuneirong;
	}
				
	
	/**
	 * 设置：维护结果
	 */
	 
	public void setWeihujieguo(String weihujieguo) {
		this.weihujieguo = weihujieguo;
	}
	
	/**
	 * 获取：维护结果
	 */
	public String getWeihujieguo() {
		return weihujieguo;
	}
			
}
