package com.hys.boot.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hys.api.domain.SysRoleVo;
import com.hys.api.domain.SysUserVo;
import com.hys.api.service.UserService;
import com.hys.boot.consumer.framework.security.ss3.CustomUserDetails;

@Service
public class CustomUserService implements UserDetailsService {
	private static final Logger log = LoggerFactory.getLogger(CustomUserService.class);
	 @Autowired
	 UserService userService;

	    @Override
	    public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户
	        SysUserVo user = userService.findByUserName(username);
	        CustomUserDetails result = null;
	        if(user == null){
	            throw new UsernameNotFoundException("用户名:"+username+"不存在");
	        }
	        List<GrantedAuthority> authorities = new ArrayList<>();
	        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
	        for(SysRoleVo role:user.getRoles())
	        {
	            authorities.add(new SimpleGrantedAuthority(role.getName()));	            
	        }
	        result = new CustomUserDetails(user.getPassword(), user.getUsername(), true, true, true, true, authorities);
            //result.setSuper(user.isSuper());
            result.setCustomUserDetails(user);

            if(log.isDebugEnabled())
                log.debug("用户" + username + "登录.");
            //getCache().put(username, result);
	        return result;
	    }
}
