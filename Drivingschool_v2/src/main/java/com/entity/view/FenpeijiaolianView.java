package com.entity.view;

import com.entity.FenpeijiaolianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * Assign coach
 * 后端return视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要return使用）
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
@TableName("fenpeijiaolian")
public class FenpeijiaolianView  extends FenpeijiaolianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FenpeijiaolianView(){
	}
 
 	public FenpeijiaolianView(FenpeijiaolianEntity fenpeijiaolianEntity){
 	try {
			BeanUtils.copyProperties(this, fenpeijiaolianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
