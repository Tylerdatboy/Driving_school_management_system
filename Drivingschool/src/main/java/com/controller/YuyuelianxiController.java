package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YuyuelianxiEntity;
import com.entity.view.YuyuelianxiView;

import com.service.YuyuelianxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * Appointment Practice
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
@RestController
@RequestMapping("/yuyuelianxi")
public class YuyuelianxiController {
    @Autowired
    private YuyuelianxiService yuyuelianxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyuelianxiEntity yuyuelianxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaxiaojiaolian")) {
			yuyuelianxi.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xueyuan")) {
			yuyuelianxi.setXueyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyuelianxiEntity> ew = new EntityWrapper<YuyuelianxiEntity>();

		PageUtils page = yuyuelianxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuelianxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyuelianxiEntity yuyuelianxi, 
		HttpServletRequest request){
        EntityWrapper<YuyuelianxiEntity> ew = new EntityWrapper<YuyuelianxiEntity>();

		PageUtils page = yuyuelianxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuelianxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyuelianxiEntity yuyuelianxi){
       	EntityWrapper<YuyuelianxiEntity> ew = new EntityWrapper<YuyuelianxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyuelianxi, "yuyuelianxi")); 
        return R.ok().put("data", yuyuelianxiService.selectListView(ew));
    }

	 /**
     * query
     */
    @RequestMapping("/query")
    public R query(YuyuelianxiEntity yuyuelianxi){
        EntityWrapper< YuyuelianxiEntity> ew = new EntityWrapper< YuyuelianxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyuelianxi, "yuyuelianxi")); 
		YuyuelianxiView yuyuelianxiView =  yuyuelianxiService.selectView(ew);
		return R.ok("queryAppointment Practice success").put("data", yuyuelianxiView);
    }
	
    /**
     * 后端info
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyuelianxiEntity yuyuelianxi = yuyuelianxiService.selectById(id);
        return R.ok().put("data", yuyuelianxi);
    }

    /**
     * 前端info
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyuelianxiEntity yuyuelianxi = yuyuelianxiService.selectById(id);
        return R.ok().put("data", yuyuelianxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuelianxiEntity yuyuelianxi, HttpServletRequest request){
    	yuyuelianxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuelianxi);
        yuyuelianxiService.insert(yuyuelianxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyuelianxiEntity yuyuelianxi, HttpServletRequest request){
    	yuyuelianxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuelianxi);
        yuyuelianxiService.insert(yuyuelianxi);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuyuelianxiEntity yuyuelianxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuelianxi);
        yuyuelianxiService.updateById(yuyuelianxi);//全部更新
        return R.ok();
    }


    

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyuelianxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YuyuelianxiEntity> wrapper = new EntityWrapper<YuyuelianxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaxiaojiaolian")) {
			wrapper.eq("jiaolianzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xueyuan")) {
			wrapper.eq("xueyuanzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = yuyuelianxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
