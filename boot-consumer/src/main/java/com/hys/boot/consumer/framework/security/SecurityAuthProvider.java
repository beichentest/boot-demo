package com.hys.boot.consumer.framework.security;

import com.hys.api.domain.SysUserVo;

public interface SecurityAuthProvider {
	public <T extends SysUserVo> T getPrincipal();

    public void auth(String accountname, String accountpassword);
    
    public void logout();

    public boolean isAuthenticated();
}
