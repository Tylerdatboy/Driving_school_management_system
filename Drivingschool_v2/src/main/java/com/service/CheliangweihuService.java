package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CheliangweihuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CheliangweihuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CheliangweihuView;


/**
 * Vehicle maintenance
 *
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public interface CheliangweihuService extends IService<CheliangweihuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangweihuVO> selectListVO(Wrapper<CheliangweihuEntity> wrapper);
   	
   	CheliangweihuVO selectVO(@Param("ew") Wrapper<CheliangweihuEntity> wrapper);
   	
   	List<CheliangweihuView> selectListView(Wrapper<CheliangweihuEntity> wrapper);
   	
   	CheliangweihuView selectView(@Param("ew") Wrapper<CheliangweihuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangweihuEntity> wrapper);
   	

}

