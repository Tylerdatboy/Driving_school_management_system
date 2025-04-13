package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KaoshianpaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KaoshianpaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KaoshianpaiView;


/**
 * Exam arrangements
 *
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public interface KaoshianpaiService extends IService<KaoshianpaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaoshianpaiVO> selectListVO(Wrapper<KaoshianpaiEntity> wrapper);
   	
   	KaoshianpaiVO selectVO(@Param("ew") Wrapper<KaoshianpaiEntity> wrapper);
   	
   	List<KaoshianpaiView> selectListView(Wrapper<KaoshianpaiEntity> wrapper);
   	
   	KaoshianpaiView selectView(@Param("ew") Wrapper<KaoshianpaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaoshianpaiEntity> wrapper);
   	

}

