package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueyuanView;


/**
 * student
 *
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public interface XueyuanService extends IService<XueyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueyuanVO> selectListVO(Wrapper<XueyuanEntity> wrapper);
   	
   	XueyuanVO selectVO(@Param("ew") Wrapper<XueyuanEntity> wrapper);
   	
   	List<XueyuanView> selectListView(Wrapper<XueyuanEntity> wrapper);
   	
   	XueyuanView selectView(@Param("ew") Wrapper<XueyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueyuanEntity> wrapper);
   	

}

