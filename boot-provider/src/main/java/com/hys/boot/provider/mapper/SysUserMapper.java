package com.hys.boot.provider.mapper;

import com.hys.api.domain.SysUserVo;
import com.hys.boot.provider.model.SysUser;
import com.hys.boot.provider.util.MyMapper;

public interface SysUserMapper extends MyMapper<SysUser> {
	public SysUserVo findByUserName(String name);
}