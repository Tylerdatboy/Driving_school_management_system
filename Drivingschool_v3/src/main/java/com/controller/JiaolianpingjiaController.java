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

import com.entity.JiaolianpingjiaEntity;
import com.entity.view.JiaolianpingjiaView;

import com.service.JiaolianpingjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * coach evaluate
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-11 19:58:42
 */
@RestController
@RequestMapping("/jiaolianpingjia")
public class JiaolianpingjiaController {
    @Autowired
    private JiaolianpingjiaService jiaolianpingjiaService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaolianpingjiaEntity jiaolianpingjia,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaxiaojiaolian")) {
			jiaolianpingjia.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xueyuan")) {
			jiaolianpingjia.setXueyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaolianpingjiaEntity> ew = new EntityWrapper<JiaolianpingjiaEntity>();

		PageUtils page = jiaolianpingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolianpingjia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaolianpingjiaEntity jiaolianpingjia, 
		HttpServletRequest request){
        EntityWrapper<JiaolianpingjiaEntity> ew = new EntityWrapper<JiaolianpingjiaEntity>();

		PageUtils page = jiaolianpingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolianpingjia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaolianpingjiaEntity jiaolianpingjia){
       	EntityWrapper<JiaolianpingjiaEntity> ew = new EntityWrapper<JiaolianpingjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaolianpingjia, "jiaolianpingjia")); 
        return R.ok().put("data", jiaolianpingjiaService.selectListView(ew));
    }

	 /**
     * query
     */
    @RequestMapping("/query")
    public R query(JiaolianpingjiaEntity jiaolianpingjia){
        EntityWrapper< JiaolianpingjiaEntity> ew = new EntityWrapper< JiaolianpingjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaolianpingjia, "jiaolianpingjia")); 
		JiaolianpingjiaView jiaolianpingjiaView =  jiaolianpingjiaService.selectView(ew);
		return R.ok("querycoach evaluate success").put("data", jiaolianpingjiaView);
    }
	
    /**
     * 后端info
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaolianpingjiaEntity jiaolianpingjia = jiaolianpingjiaService.selectById(id);
        return R.ok().put("data", jiaolianpingjia);
    }

    /**
     * 前端info
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaolianpingjiaEntity jiaolianpingjia = jiaolianpingjiaService.selectById(id);
        return R.ok().put("data", jiaolianpingjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaolianpingjiaEntity jiaolianpingjia, HttpServletRequest request){
    	jiaolianpingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaolianpingjia);
        jiaolianpingjiaService.insert(jiaolianpingjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaolianpingjiaEntity jiaolianpingjia, HttpServletRequest request){
    	jiaolianpingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaolianpingjia);
        jiaolianpingjiaService.insert(jiaolianpingjia);
        return R.ok();
    }



    /**
     * modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaolianpingjiaEntity jiaolianpingjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaolianpingjia);
        jiaolianpingjiaService.updateById(jiaolianpingjia);//全部更新
        return R.ok();
    }


    

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaolianpingjiaService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<JiaolianpingjiaEntity> wrapper = new EntityWrapper<JiaolianpingjiaEntity>();
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

		int count = jiaolianpingjiaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
