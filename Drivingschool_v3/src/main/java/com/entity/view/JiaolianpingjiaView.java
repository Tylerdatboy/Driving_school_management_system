package com.entity.view;

import com.entity.JiaolianpingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * coach evaluate
 * 后端return视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要return使用）
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
@TableName("jiaolianpingjia")
public class JiaolianpingjiaView  extends JiaolianpingjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiaolianpingjiaView(){
	}
 
 	public JiaolianpingjiaView(JiaolianpingjiaEntity jiaolianpingjiaEntity){
 	try {
			BeanUtils.copyProperties(this, jiaolianpingjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
