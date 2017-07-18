package com.hys.api.domain;

import java.io.Serializable;
import java.util.List;


public class SysPermissionVo implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8385324526216567033L;

	private Integer id;

    private String name;

    private String descritpion;

    private String url;

    private Integer pid;
    
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return descritpion
     */
    public String getDescritpion() {
        return descritpion;
    }

    /**
     * @param descritpion
     */
    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

	public List<SysRoleVo> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRoleVo> roles) {
		this.roles = roles;
	}	
}