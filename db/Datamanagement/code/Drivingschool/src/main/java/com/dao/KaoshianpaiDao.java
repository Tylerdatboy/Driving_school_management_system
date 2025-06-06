package com.dao;

import com.entity.KaoshianpaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KaoshianpaiVO;
import com.entity.view.KaoshianpaiView;


/**
 * Exam arrangements
 * 
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public interface KaoshianpaiDao extends BaseMapper<KaoshianpaiEntity> {
	
	List<KaoshianpaiVO> selectListVO(@Param("ew") Wrapper<KaoshianpaiEntity> wrapper);
	
	KaoshianpaiVO selectVO(@Param("ew") Wrapper<KaoshianpaiEntity> wrapper);
	
	List<KaoshianpaiView> selectListView(@Param("ew") Wrapper<KaoshianpaiEntity> wrapper);

	List<KaoshianpaiView> selectListView(Pagination page,@Param("ew") Wrapper<KaoshianpaiEntity> wrapper);
	
	KaoshianpaiView selectView(@Param("ew") Wrapper<KaoshianpaiEntity> wrapper);
	

}
