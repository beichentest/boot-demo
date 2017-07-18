package com.hys.api.domain;

import java.io.Serializable;
import java.util.List;

public class SysUserVo  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5986797259369313676L;

    private Integer id;

    private String username;

    private String password;

    private List<SysRoleVo> roles;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

	public List<SysRoleVo> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRoleVo> roles) {
		this.roles = roles;
	}    
}