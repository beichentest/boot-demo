package com.hys.boot.provider.mapper;

import java.util.List;

import com.hys.api.domain.SysPermissionVo;
import com.hys.boot.provider.model.SysPermission;
import com.hys.boot.provider.util.MyMapper;

public interface SysPermissionMapper extends MyMapper<SysPermission> {
	public SysPermissionVo findByUserId(Integer userId);
	
	public List<SysPermissionVo> findAll();
}