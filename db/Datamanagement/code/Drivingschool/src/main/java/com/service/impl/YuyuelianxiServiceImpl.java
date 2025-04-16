package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YuyuelianxiDao;
import com.entity.YuyuelianxiEntity;
import com.service.YuyuelianxiService;
import com.entity.vo.YuyuelianxiVO;
import com.entity.view.YuyuelianxiView;

@Service("yuyuelianxiService")
public class YuyuelianxiServiceImpl extends ServiceImpl<YuyuelianxiDao, YuyuelianxiEntity> implements YuyuelianxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyuelianxiEntity> page = this.selectPage(
                new Query<YuyuelianxiEntity>(params).getPage(),
                new EntityWrapper<YuyuelianxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyuelianxiEntity> wrapper) {
		  Page<YuyuelianxiView> page =new Query<YuyuelianxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuyuelianxiVO> selectListVO(Wrapper<YuyuelianxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuyuelianxiVO selectVO(Wrapper<YuyuelianxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuyuelianxiView> selectListView(Wrapper<YuyuelianxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyuelianxiView selectView(Wrapper<YuyuelianxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
