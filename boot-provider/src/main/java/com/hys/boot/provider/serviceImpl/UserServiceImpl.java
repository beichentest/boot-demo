package com.hys.boot.provider.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hys.api.domain.SysUserVo;
import com.hys.api.service.UserService;
import com.hys.boot.provider.mapper.SysUserMapper;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private SysUserMapper userDao;
	@Override
	public SysUserVo findByUserName(String name) {
		return userDao.findByUserName(name);
	}

}
