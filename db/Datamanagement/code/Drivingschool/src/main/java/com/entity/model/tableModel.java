package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * Appointment Practice
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author
 * @email
 * @date 2023-03-11 19:58:42
 */
@Data
public class tableModel implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * Coach Name
	 */

	private String[] dates;



}
