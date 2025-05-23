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

import com.entity.XueyuanEntity;
import com.entity.view.XueyuanView;

import com.service.XueyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * student
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
@RestController
@RequestMapping("/xueyuan")
public class XueyuanController {
    @Autowired
    private XueyuanService xueyuanService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * Login 
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		XueyuanEntity u = xueyuanService.selectOne(new EntityWrapper<XueyuanEntity>().eq("xueyuanzhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("userName Or password Invalid");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"xueyuan",  "student" );
		return R.ok().put("token", token);
	}

	
	/**
     * Registered
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody XueyuanEntity xueyuan){
    	//ValidatorUtils.validateEntity(xueyuan);
    	XueyuanEntity u = xueyuanService.selectOne(new EntityWrapper<XueyuanEntity>().eq("xueyuanzhanghao", xueyuan.getXueyuanzhanghao()));
		if(u!=null) {
			return R.error("Registered user already exists");
		}
		Long uId = new Date().getTime();
		xueyuan.setId(uId);
        xueyuanService.insert(xueyuan);
        return R.ok();
    }

	
	/**
	 * exit
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("exit success");
	}
	
	/**
     * 获取User 的sessionUser 信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        XueyuanEntity u = xueyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * passwordReset 
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	XueyuanEntity u = xueyuanService.selectOne(new EntityWrapper<XueyuanEntity>().eq("xueyuanzhanghao", username));
    	if(u==null) {
    		return R.error("Account does not exist");
    	}
        u.setMima("123456");
        xueyuanService.updateById(u);
        return R.ok("password已Reset 为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueyuanEntity xueyuan,
		HttpServletRequest request){
        EntityWrapper<XueyuanEntity> ew = new EntityWrapper<XueyuanEntity>();

		PageUtils page = xueyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueyuanEntity xueyuan, 
		HttpServletRequest request){
        EntityWrapper<XueyuanEntity> ew = new EntityWrapper<XueyuanEntity>();

		PageUtils page = xueyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueyuanEntity xueyuan){
       	EntityWrapper<XueyuanEntity> ew = new EntityWrapper<XueyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueyuan, "xueyuan")); 
        return R.ok().put("data", xueyuanService.selectListView(ew));
    }

	 /**
     * query
     */
    @RequestMapping("/query")
    public R query(XueyuanEntity xueyuan){
        EntityWrapper< XueyuanEntity> ew = new EntityWrapper< XueyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueyuan, "xueyuan")); 
		XueyuanView xueyuanView =  xueyuanService.selectView(ew);
		return R.ok("querystudent success").put("data", xueyuanView);
    }
	
    /**
     * 后端info
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueyuanEntity xueyuan = xueyuanService.selectById(id);
        return R.ok().put("data", xueyuan);
    }

    /**
     * 前端info
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueyuanEntity xueyuan = xueyuanService.selectById(id);
        return R.ok().put("data", xueyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueyuanEntity xueyuan, HttpServletRequest request){
    	xueyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueyuan);
    	XueyuanEntity u = xueyuanService.selectOne(new EntityWrapper<XueyuanEntity>().eq("xueyuanzhanghao", xueyuan.getXueyuanzhanghao()));
		if(u!=null) {
			return R.error("User  Already exists");
		}
		xueyuan.setId(new Date().getTime());
        xueyuanService.insert(xueyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueyuanEntity xueyuan, HttpServletRequest request){
    	xueyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueyuan);
    	XueyuanEntity u = xueyuanService.selectOne(new EntityWrapper<XueyuanEntity>().eq("xueyuanzhanghao", xueyuan.getXueyuanzhanghao()));
		if(u!=null) {
			return R.error("User  Already exists");
		}
		xueyuan.setId(new Date().getTime());
        xueyuanService.insert(xueyuan);
        return R.ok();
    }

     /**
     * 获取User 密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        XueyuanEntity xueyuan = xueyuanService.selectOne(new EntityWrapper<XueyuanEntity>().eq("xueyuanzhanghao", username));
        return R.ok().put("data", xueyuan);
    }


    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody XueyuanEntity xueyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueyuan);
        xueyuanService.updateById(xueyuan);//全部更新
        return R.ok();
    }


    

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueyuanService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<XueyuanEntity> wrapper = new EntityWrapper<XueyuanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = xueyuanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
