package com.hys.api.service;

import java.util.List;

import com.hys.api.domain.SysPermissionVo;

public interface PermissionService {
	public SysPermissionVo findByUserId(Integer userId);	
	public List<SysPermissionVo> findAll();
}
