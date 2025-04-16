package com.entity.view;

import com.entity.JiaxiaobaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * Registration for Driving School
 * 后端return视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要return使用）
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
@TableName("jiaxiaobaoming")
public class JiaxiaobaomingView  extends JiaxiaobaomingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiaxiaobaomingView(){
	}
 
 	public JiaxiaobaomingView(JiaxiaobaomingEntity jiaxiaobaomingEntity){
 	try {
			BeanUtils.copyProperties(this, jiaxiaobaomingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
