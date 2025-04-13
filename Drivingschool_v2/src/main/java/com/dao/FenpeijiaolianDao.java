package com.dao;

import com.entity.FenpeijiaolianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FenpeijiaolianVO;
import com.entity.view.FenpeijiaolianView;


/**
 * Assign coach
 * 
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public interface FenpeijiaolianDao extends BaseMapper<FenpeijiaolianEntity> {
	
	List<FenpeijiaolianVO> selectListVO(@Param("ew") Wrapper<FenpeijiaolianEntity> wrapper);
	
	FenpeijiaolianVO selectVO(@Param("ew") Wrapper<FenpeijiaolianEntity> wrapper);
	
	List<FenpeijiaolianView> selectListView(@Param("ew") Wrapper<FenpeijiaolianEntity> wrapper);

	List<FenpeijiaolianView> selectListView(Pagination page,@Param("ew") Wrapper<FenpeijiaolianEntity> wrapper);
	
	FenpeijiaolianView selectView(@Param("ew") Wrapper<FenpeijiaolianEntity> wrapper);
	

}
