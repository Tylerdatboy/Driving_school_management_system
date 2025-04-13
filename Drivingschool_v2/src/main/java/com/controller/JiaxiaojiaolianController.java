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

import com.entity.JiaxiaojiaolianEntity;
import com.entity.view.JiaxiaojiaolianView;

import com.service.JiaxiaojiaolianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * Driving school coach
 * 后端接口
 * @author
 * @email
 * @date 2023-03-11 19:58:42
 */
@RestController
@RequestMapping("/jiaxiaojiaolian")
public class JiaxiaojiaolianController {
    @Autowired
    private JiaxiaojiaolianService jiaxiaojiaolianService;



	@Autowired
	private TokenService tokenService;

	/**
	 * Login
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		JiaxiaojiaolianEntity u = jiaxiaojiaolianService.selectOne(new EntityWrapper<JiaxiaojiaolianEntity>().eq("jiaolianzhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("userName Or password Invalid");
		}

		String token = tokenService.generateToken(u.getId(), username,"jiaxiaojiaolian",  "Driving school coach" );
		return R.ok().put("token", token);
	}


	/**
     * Registered
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody JiaxiaojiaolianEntity jiaxiaojiaolian){
    	//ValidatorUtils.validateEntity(jiaxiaojiaolian);
    	JiaxiaojiaolianEntity u = jiaxiaojiaolianService.selectOne(new EntityWrapper<JiaxiaojiaolianEntity>().eq("jiaolianzhanghao", jiaxiaojiaolian.getJiaolianzhanghao()));
		if(u!=null) {
			return R.error("Registered user already exists");
		}
		Long uId = new Date().getTime();
		jiaxiaojiaolian.setId(uId);
        jiaxiaojiaolianService.insert(jiaxiaojiaolian);
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
        JiaxiaojiaolianEntity u = jiaxiaojiaolianService.selectById(id);
        return R.ok().put("data", u);
    }

    /**
     * passwordReset
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	JiaxiaojiaolianEntity u = jiaxiaojiaolianService.selectOne(new EntityWrapper<JiaxiaojiaolianEntity>().eq("jiaolianzhanghao", username));
    	if(u==null) {
    		return R.error("Account does not exist");
    	}
        u.setMima("123456");
        jiaxiaojiaolianService.updateById(u);
        return R.ok("password for Reset ：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaxiaojiaolianEntity jiaxiaojiaolian,
		HttpServletRequest request){
        EntityWrapper<JiaxiaojiaolianEntity> ew = new EntityWrapper<JiaxiaojiaolianEntity>();

		PageUtils page = jiaxiaojiaolianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaxiaojiaolian), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaxiaojiaolianEntity jiaxiaojiaolian,
		HttpServletRequest request){
        EntityWrapper<JiaxiaojiaolianEntity> ew = new EntityWrapper<JiaxiaojiaolianEntity>();

		PageUtils page = jiaxiaojiaolianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaxiaojiaolian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaxiaojiaolianEntity jiaxiaojiaolian){
       	EntityWrapper<JiaxiaojiaolianEntity> ew = new EntityWrapper<JiaxiaojiaolianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaxiaojiaolian, "jiaxiaojiaolian"));
        return R.ok().put("data", jiaxiaojiaolianService.selectListView(ew));
    }

	 /**
     * query
     */
    @RequestMapping("/query")
    public R query(JiaxiaojiaolianEntity jiaxiaojiaolian){
        EntityWrapper< JiaxiaojiaolianEntity> ew = new EntityWrapper< JiaxiaojiaolianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaxiaojiaolian, "jiaxiaojiaolian"));
		JiaxiaojiaolianView jiaxiaojiaolianView =  jiaxiaojiaolianService.selectView(ew);
		return R.ok("queryDriving school coach success").put("data", jiaxiaojiaolianView);
    }

    /**
     * 后端info
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaxiaojiaolianEntity jiaxiaojiaolian = jiaxiaojiaolianService.selectById(id);
        return R.ok().put("data", jiaxiaojiaolian);
    }

    /**
     * 前端info
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaxiaojiaolianEntity jiaxiaojiaolian = jiaxiaojiaolianService.selectById(id);
        return R.ok().put("data", jiaxiaojiaolian);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaxiaojiaolianEntity jiaxiaojiaolian, HttpServletRequest request){
    	jiaxiaojiaolian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaxiaojiaolian);
    	JiaxiaojiaolianEntity u = jiaxiaojiaolianService.selectOne(new EntityWrapper<JiaxiaojiaolianEntity>().eq("jiaolianzhanghao", jiaxiaojiaolian.getJiaolianzhanghao()));
		if(u!=null) {
			return R.error("User  Already exists");
		}
		jiaxiaojiaolian.setId(new Date().getTime());
        jiaxiaojiaolianService.insert(jiaxiaojiaolian);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaxiaojiaolianEntity jiaxiaojiaolian, HttpServletRequest request){
    	jiaxiaojiaolian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaxiaojiaolian);
    	JiaxiaojiaolianEntity u = jiaxiaojiaolianService.selectOne(new EntityWrapper<JiaxiaojiaolianEntity>().eq("jiaolianzhanghao", jiaxiaojiaolian.getJiaolianzhanghao()));
		if(u!=null) {
			return R.error("User  Already exists");
		}
		jiaxiaojiaolian.setId(new Date().getTime());
        jiaxiaojiaolianService.insert(jiaxiaojiaolian);
        return R.ok();
    }

     /**
     * 获取User 密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        JiaxiaojiaolianEntity jiaxiaojiaolian = jiaxiaojiaolianService.selectOne(new EntityWrapper<JiaxiaojiaolianEntity>().eq("jiaolianzhanghao", username));
        return R.ok().put("data", jiaxiaojiaolian);
    }


    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody JiaxiaojiaolianEntity jiaxiaojiaolian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaxiaojiaolian);
        jiaxiaojiaolianService.updateById(jiaxiaojiaolian);//全部更新
        return R.ok();
    }




    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaxiaojiaolianService.deleteBatchIds(Arrays.asList(ids));
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

		Wrapper<JiaxiaojiaolianEntity> wrapper = new EntityWrapper<JiaxiaojiaolianEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = jiaxiaojiaolianService.selectCount(wrapper);
		return R.ok().put("count", count);
	}










}
