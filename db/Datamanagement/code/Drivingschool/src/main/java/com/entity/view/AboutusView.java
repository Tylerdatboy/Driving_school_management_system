package com.entity.view;

import com.entity.AboutusEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * About Us
 * 后端return视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要return使用）
 * @author 
 * @email 
 * @date 2023-03-11 19:58:43
 */
@TableName("aboutus")
public class AboutusView  extends AboutusEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AboutusView(){
	}
 
 	public AboutusView(AboutusEntity aboutusEntity){
 	try {
			BeanUtils.copyProperties(this, aboutusEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
