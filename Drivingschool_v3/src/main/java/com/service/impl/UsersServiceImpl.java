
package com.service.impl;


import java.time.LocalTime;
import java.util.*;

import com.entity.Time;
import com.entity.TimeRange;
import com.entity.listDTO;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.UsersDao;
import com.entity.UsersEntity;
import com.service.UsersService;
import com.utils.PageUtils;
import com.utils.Query;

import javax.servlet.http.HttpServletRequest;


/**
 * System User
 */
@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersDao, UsersEntity> implements UsersService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<UsersEntity> page = this.selectPage(
                new Query<UsersEntity>(params).getPage(),
                new EntityWrapper<UsersEntity>()
        );
        return new PageUtils(page);
	}

	@Override
	public List<UsersEntity> selectListView(Wrapper<UsersEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params,
			Wrapper<UsersEntity> wrapper) {
		 Page<UsersEntity> page =new Query<UsersEntity>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
	}

	@Override
	public UsersEntity schedule(UsersEntity users, HttpServletRequest request) {



		String tableName = request.getSession().getAttribute("tableName").toString();
		String username = (String) request.getSession().getAttribute("username");
		Map<String, boolean[]> resultMap = new LinkedHashMap<>();
		List<Time> time1 = new ArrayList<>();
		UsersEntity usersEntity = new UsersEntity();
		users.setStudentName(username);
		List<TimeRange> predefinedRanges = Arrays.asList(
				new TimeRange("08:00", "10:00"),
				new TimeRange("10:00", "12:00"),
				new TimeRange("14:00", "16:00"),
				new TimeRange("16:00", "18:00"),
				new TimeRange("19:00", "21:00")
		);
		for (String d :users.getDates()){
			List<UsersEntity> dto = new ArrayList<>();
			users.setDate(d);
			if(tableName.equals("jiaxiaojiaolian")) {
				dto= baseMapper.selectListss(users);
			}else {
				dto= baseMapper.selectLists(users);
			}

			boolean[] dateResult = new boolean[predefinedRanges.size()];
			Arrays.fill(dateResult, false); // 默认所有区间未覆盖

			for (UsersEntity entity : dto) {
				LocalTime start = LocalTime.parse(entity.getStartTime());
				LocalTime end = LocalTime.parse(entity.getEndTime());

				for (int i = 0; i < predefinedRanges.size(); i++) {
					if (dateResult[i]) continue; // 已标记为true则跳过
					TimeRange range = predefinedRanges.get(i);
					if (isTimeOverlap(start, end, range.getStart(), range.getEnd())) {
						dateResult[i] = true;
					}
				}
			}
			Time time = new Time();// 按日期顺序保存结果
			time.setTime(d);
			time.setBool(dateResult);
			time1.add(time);
			resultMap.put(d, dateResult);
			System.out.println(dto);
		}
		usersEntity.setTimeType(resultMap);

		return usersEntity;
	}

	@Override
	public void inserts(UsersEntity users) {
		String range = users.getRange();
		String[] times = range.split("-"); // 用 "-" 分割字符串
		users.setStartTime(times[0]);
		users.setEndTime(times[1]);
		baseMapper.inserts(users);
	}

	@Override
	public List<listDTO> select() {
		return baseMapper.select();
	}

	@Override
	public int selectId(String username) {
		return baseMapper.selectid(username);
	}

	// 判断时间段是否有重叠的方法
	private boolean isTimeOverlap(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
		return start1.isBefore(end2) && start2.isBefore(end1);
	}
}
