package com.hys.api.domain;

import java.io.Serializable;

public class SysRoleVo implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3823145836700906323L;

	private Integer id;

    private String name;

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
}