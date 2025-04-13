package com.dao;

import com.entity.YuyuelianxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuyuelianxiVO;
import com.entity.view.YuyuelianxiView;


/**
 * Appointment Practice
 * 
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public interface YuyuelianxiDao extends BaseMapper<YuyuelianxiEntity> {
	
	List<YuyuelianxiVO> selectListVO(@Param("ew") Wrapper<YuyuelianxiEntity> wrapper);
	
	YuyuelianxiVO selectVO(@Param("ew") Wrapper<YuyuelianxiEntity> wrapper);
	
	List<YuyuelianxiView> selectListView(@Param("ew") Wrapper<YuyuelianxiEntity> wrapper);

	List<YuyuelianxiView> selectListView(Pagination page,@Param("ew") Wrapper<YuyuelianxiEntity> wrapper);
	
	YuyuelianxiView selectView(@Param("ew") Wrapper<YuyuelianxiEntity> wrapper);
	

}
