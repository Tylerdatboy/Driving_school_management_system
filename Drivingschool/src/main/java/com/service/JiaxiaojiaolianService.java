package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaxiaojiaolianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaxiaojiaolianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaxiaojiaolianView;


/**
 * Driving school coach
 *
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public interface JiaxiaojiaolianService extends IService<JiaxiaojiaolianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaxiaojiaolianVO> selectListVO(Wrapper<JiaxiaojiaolianEntity> wrapper);
   	
   	JiaxiaojiaolianVO selectVO(@Param("ew") Wrapper<JiaxiaojiaolianEntity> wrapper);
   	
   	List<JiaxiaojiaolianView> selectListView(Wrapper<JiaxiaojiaolianEntity> wrapper);
   	
   	JiaxiaojiaolianView selectView(@Param("ew") Wrapper<JiaxiaojiaolianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaxiaojiaolianEntity> wrapper);
   	

}

