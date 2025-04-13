package com.dao;

import com.entity.CheliangweihuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CheliangweihuVO;
import com.entity.view.CheliangweihuView;


/**
 * Vehicle maintenance
 * 
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
public interface CheliangweihuDao extends BaseMapper<CheliangweihuEntity> {
	
	List<CheliangweihuVO> selectListVO(@Param("ew") Wrapper<CheliangweihuEntity> wrapper);
	
	CheliangweihuVO selectVO(@Param("ew") Wrapper<CheliangweihuEntity> wrapper);
	
	List<CheliangweihuView> selectListView(@Param("ew") Wrapper<CheliangweihuEntity> wrapper);

	List<CheliangweihuView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangweihuEntity> wrapper);
	
	CheliangweihuView selectView(@Param("ew") Wrapper<CheliangweihuEntity> wrapper);
	

}
