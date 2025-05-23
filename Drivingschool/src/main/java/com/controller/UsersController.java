
package com.controller;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.entity.listDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.UsersEntity;
import com.service.TokenService;
import com.service.UsersService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;

/**
 * Login 相关
 */
@RequestMapping("users")
@RestController
public class UsersController{

	@Autowired
	private UsersService userService;

	@Autowired
	private TokenService tokenService;

	/**
	 * Login
	 */
	@IgnoreAuth
	@PostMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		UsersEntity user = userService.selectOne(new EntityWrapper<UsersEntity>().eq("username", username));
		if(user==null || !user.getPassword().equals(password)) {
			return R.error("userName Or password Invalid");
		}
		String token = tokenService.generateToken(user.getId(),username, "users", user.getRole());
		return R.ok().put("token", token);
	}

	/**
	 * Registered
	 */
	@IgnoreAuth
	@PostMapping(value = "/register")
	public R register(@RequestBody UsersEntity user){
//    	ValidatorUtils.validateEntity(user);
    	if(userService.selectOne(new EntityWrapper<UsersEntity>().eq("username", user.getUsername())) !=null) {
    		return R.error("User  Already exists");
    	}
        userService.insert(user);
        return R.ok();
    }

	/**
	 * exit
	 */
	@GetMapping(value = "logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("exit success");
	}

	/**
     * passwordReset
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	UsersEntity user = userService.selectOne(new EntityWrapper<UsersEntity>().eq("username", username));
    	if(user==null) {
    		return R.error("Account does not exist");
    	}
    	user.setPassword("123456");
        userService.update(user,null);
        return R.ok("password已Reset 为：123456");
    }

	/**
     * 列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,UsersEntity user){
        EntityWrapper<UsersEntity> ew = new EntityWrapper<UsersEntity>();
    	PageUtils page = userService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, user), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/list")
    public R list( UsersEntity user){
       	EntityWrapper<UsersEntity> ew = new EntityWrapper<UsersEntity>();
      	ew.allEq(MPUtil.allEQMapPre( user, "user"));
        return R.ok().put("data", userService.selectListView(ew));
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        UsersEntity user = userService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
     * 获取User 的sessionUser 信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        UsersEntity user = userService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody UsersEntity user){
//    	ValidatorUtils.validateEntity(user);
    	if(userService.selectOne(new EntityWrapper<UsersEntity>().eq("username", user.getUsername())) !=null) {
    		return R.error("User  Already exists");
    	}
        userService.insert(user);
        return R.ok();
    }

    /**
     * modify
     */
    @RequestMapping("/update")
    public R update(@RequestBody UsersEntity user){
//        ValidatorUtils.validateEntity(user);
    	UsersEntity u = userService.selectOne(new EntityWrapper<UsersEntity>().eq("username", user.getUsername()));
    	if(u!=null && u.getId()!=user.getId() && u.getUsername().equals(user.getUsername())) {
    		return R.error("userName Already exists。");
    	}
        userService.updateById(user);//全部更新
        return R.ok();
    }

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        userService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

	@RequestMapping("/schedule")
    public R schedule(@RequestBody  UsersEntity users,HttpServletRequest request){
		if (ObjectUtils.isEmpty(request.getSession().getAttribute("username"))){
			return R.error("请先登录");
		}
		UsersEntity u = userService.schedule(users,request);
        return R.ok().put("data", u);
    }
	@RequestMapping("/insert")
    public R insert(@RequestBody  UsersEntity users,HttpServletRequest request){
		if (ObjectUtils.isEmpty(request.getSession().getAttribute("username"))){
			return R.error("请先登录");
		}
		users.setStudentName(String.valueOf(request.getSession().getAttribute("username")));
		userService.inserts(users);
        return R.ok();
    }

	@RequestMapping("/select")
    public R select(HttpServletRequest request){
		if (ObjectUtils.isEmpty(request.getSession().getAttribute("username"))){
			return R.error("请先登录");
		}
		List<listDTO> dto = userService.select();
		return R.ok().put("data", dto);
    }

	@RequestMapping("/type")
    public R type(HttpServletRequest request){
		if (ObjectUtils.isEmpty(request.getSession().getAttribute("username"))){
			return R.error("请先登录");
		}


		String tableName = request.getSession().getAttribute("tableName").toString();
		Object username = request.getSession().getAttribute("username");
		int id='1';
		if (!tableName.equals("xueyuan")){
			 id = userService.selectId((String)username);
		}

		UsersEntity usersEntity = new UsersEntity();
		usersEntity.setTableName(tableName);
		usersEntity.setUsername((String) username);
		usersEntity.setId((long) id);

		return R.ok().put("data", usersEntity);
    }
}
