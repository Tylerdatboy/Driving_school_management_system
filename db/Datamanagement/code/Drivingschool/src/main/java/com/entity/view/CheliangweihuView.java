package com.entity.view;

import com.entity.CheliangweihuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * Vehicle maintenance
 * 后端return视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要return使用）
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
@TableName("cheliangweihu")
public class CheliangweihuView  extends CheliangweihuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CheliangweihuView(){
	}
 
 	public CheliangweihuView(CheliangweihuEntity cheliangweihuEntity){
 	try {
			BeanUtils.copyProperties(this, cheliangweihuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
