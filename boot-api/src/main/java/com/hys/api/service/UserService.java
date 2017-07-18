package com.hys.api.service;

import com.hys.api.domain.SysUserVo;

public interface UserService {
	public SysUserVo findByUserName(String name);
}
