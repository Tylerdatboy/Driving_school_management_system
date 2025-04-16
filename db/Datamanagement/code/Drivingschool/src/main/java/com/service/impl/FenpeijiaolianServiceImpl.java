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


import com.dao.FenpeijiaolianDao;
import com.entity.FenpeijiaolianEntity;
import com.service.FenpeijiaolianService;
import com.entity.vo.FenpeijiaolianVO;
import com.entity.view.FenpeijiaolianView;

@Service("fenpeijiaolianService")
public class FenpeijiaolianServiceImpl extends ServiceImpl<FenpeijiaolianDao, FenpeijiaolianEntity> implements FenpeijiaolianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FenpeijiaolianEntity> page = this.selectPage(
                new Query<FenpeijiaolianEntity>(params).getPage(),
                new EntityWrapper<FenpeijiaolianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FenpeijiaolianEntity> wrapper) {
		  Page<FenpeijiaolianView> page =new Query<FenpeijiaolianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FenpeijiaolianVO> selectListVO(Wrapper<FenpeijiaolianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FenpeijiaolianVO selectVO(Wrapper<FenpeijiaolianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FenpeijiaolianView> selectListView(Wrapper<FenpeijiaolianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FenpeijiaolianView selectView(Wrapper<FenpeijiaolianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
