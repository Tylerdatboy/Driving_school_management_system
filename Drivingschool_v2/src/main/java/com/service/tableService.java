package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.YuyuelianxiEntity;
import com.entity.view.YuyuelianxiView;
import com.entity.vo.YuyuelianxiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * Appointment Practice
 *
 * @author
 * @email
 * @date 2023-03-11 19:58:42
 */
public interface tableService extends IService<YuyuelianxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<YuyuelianxiVO> selectListVO(Wrapper<YuyuelianxiEntity> wrapper);

   	YuyuelianxiVO selectVO(@Param("ew") Wrapper<YuyuelianxiEntity> wrapper);

   	List<YuyuelianxiView> selectListView(Wrapper<YuyuelianxiEntity> wrapper);

   	YuyuelianxiView selectView(@Param("ew") Wrapper<YuyuelianxiEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyuelianxiEntity> wrapper);


}

