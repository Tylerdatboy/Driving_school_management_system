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

import com.entity.CheliangweihuEntity;
import com.entity.view.CheliangweihuView;

import com.service.CheliangweihuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * Vehicle maintenance
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
@RestController
@RequestMapping("/cheliangweihu")
public class CheliangweihuController {
    @Autowired
    private CheliangweihuService cheliangweihuService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CheliangweihuEntity cheliangweihu,
		HttpServletRequest request){
        EntityWrapper<CheliangweihuEntity> ew = new EntityWrapper<CheliangweihuEntity>();

		PageUtils page = cheliangweihuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangweihu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CheliangweihuEntity cheliangweihu, 
		HttpServletRequest request){
        EntityWrapper<CheliangweihuEntity> ew = new EntityWrapper<CheliangweihuEntity>();

		PageUtils page = cheliangweihuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangweihu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CheliangweihuEntity cheliangweihu){
       	EntityWrapper<CheliangweihuEntity> ew = new EntityWrapper<CheliangweihuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cheliangweihu, "cheliangweihu")); 
        return R.ok().put("data", cheliangweihuService.selectListView(ew));
    }

	 /**
     * query
     */
    @RequestMapping("/query")
    public R query(CheliangweihuEntity cheliangweihu){
        EntityWrapper< CheliangweihuEntity> ew = new EntityWrapper< CheliangweihuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cheliangweihu, "cheliangweihu")); 
		CheliangweihuView cheliangweihuView =  cheliangweihuService.selectView(ew);
		return R.ok("queryVehicle maintenance success").put("data", cheliangweihuView);
    }
	
    /**
     * 后端info
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CheliangweihuEntity cheliangweihu = cheliangweihuService.selectById(id);
        return R.ok().put("data", cheliangweihu);
    }

    /**
     * 前端info
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CheliangweihuEntity cheliangweihu = cheliangweihuService.selectById(id);
        return R.ok().put("data", cheliangweihu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CheliangweihuEntity cheliangweihu, HttpServletRequest request){
    	cheliangweihu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheliangweihu);
        cheliangweihuService.insert(cheliangweihu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CheliangweihuEntity cheliangweihu, HttpServletRequest request){
    	cheliangweihu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheliangweihu);
        cheliangweihuService.insert(cheliangweihu);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CheliangweihuEntity cheliangweihu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheliangweihu);
        cheliangweihuService.updateById(cheliangweihu);//全部更新
        return R.ok();
    }


    

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cheliangweihuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<CheliangweihuEntity> wrapper = new EntityWrapper<CheliangweihuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = cheliangweihuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
