
package com.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.UsersEntity;
import com.entity.listDTO;
import com.utils.PageUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * System User
 */
public interface UsersService extends IService<UsersEntity> {
 	PageUtils queryPage(Map<String, Object> params);

   	List<UsersEntity> selectListView(Wrapper<UsersEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<UsersEntity> wrapper);

	UsersEntity schedule(UsersEntity users, HttpServletRequest request);

	void inserts(UsersEntity users);

	List<listDTO> select();

	int selectId(String username);
}
