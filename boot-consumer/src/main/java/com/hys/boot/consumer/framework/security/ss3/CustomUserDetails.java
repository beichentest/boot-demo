package com.hys.boot.consumer.framework.security.ss3;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hys.api.domain.SysUserVo;
/**
 * 创建UserDetails的实现类，本质为用户详细信息的一个载体 在实现类中可以进一步扩展属性
 */
public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = -6412643874655448035L;

    private Collection<GrantedAuthority> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private boolean isSuper;
    private SysUserVo customUserDetails;

    public CustomUserDetails() {
    }
    
    public CustomUserDetails(String password, String username, boolean accountNonExpired, boolean accountNonLocked,
            boolean credentialsNonExpired, boolean enabled, List<GrantedAuthority> gAuthoritys) {

        this.password = password;
        this.username = username;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.authorities = gAuthoritys;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isSuper() {
        return isSuper;
    }

    public void setSuper(boolean isSuper) {
        this.isSuper = isSuper;
    }

   

    public SysUserVo getCustomUserDetails() {
		return customUserDetails;
	}

	public void setCustomUserDetails(SysUserVo customUserDetails) {
		this.customUserDetails = customUserDetails;
	}

	@Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
