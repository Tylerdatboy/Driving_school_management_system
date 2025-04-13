package com.entity.view;

import com.entity.XuexijihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * study plan
 * 后端return视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要return使用）
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
@TableName("xuexijihua")
public class XuexijihuaView  extends XuexijihuaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XuexijihuaView(){
	}
 
 	public XuexijihuaView(XuexijihuaEntity xuexijihuaEntity){
 	try {
			BeanUtils.copyProperties(this, xuexijihuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
