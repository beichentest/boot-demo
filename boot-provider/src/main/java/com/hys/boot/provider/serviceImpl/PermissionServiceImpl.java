package com.hys.boot.provider.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hys.api.domain.SysPermissionVo;
import com.hys.api.service.PermissionService;
import com.hys.boot.provider.mapper.SysPermissionMapper;
@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private SysPermissionMapper permissionDao;
	@Override
	public SysPermissionVo findByUserId(Integer userId) {
		return permissionDao.findByUserId(userId);
	}

	@Override
	public List<SysPermissionVo> findAll() {
		return permissionDao.findAll();
	}

}
