
package com.dao;

import java.util.List;

import com.entity.listDTO;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.UsersEntity;

/**
 * User
 */
public interface UsersDao extends BaseMapper<UsersEntity> {

	List<UsersEntity> selectListView(@Param("ew") Wrapper<UsersEntity> wrapper);

	List<UsersEntity> selectListView(Pagination page,@Param("ew") Wrapper<UsersEntity> wrapper);

	List<UsersEntity> selectLists(UsersEntity users);

	void inserts(UsersEntity users);

	List<listDTO> select();

	List<UsersEntity> selectListss(UsersEntity users);

	int selectid(String username);
}
