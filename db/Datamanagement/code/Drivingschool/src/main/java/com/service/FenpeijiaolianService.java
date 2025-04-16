package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FenpeijiaolianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FenpeijiaolianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FenpeijiaolianView;


/**
 * Assign coach
 *
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public interface FenpeijiaolianService extends IService<FenpeijiaolianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FenpeijiaolianVO> selectListVO(Wrapper<FenpeijiaolianEntity> wrapper);
   	
   	FenpeijiaolianVO selectVO(@Param("ew") Wrapper<FenpeijiaolianEntity> wrapper);
   	
   	List<FenpeijiaolianView> selectListView(Wrapper<FenpeijiaolianEntity> wrapper);
   	
   	FenpeijiaolianView selectView(@Param("ew") Wrapper<FenpeijiaolianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FenpeijiaolianEntity> wrapper);
   	

}

