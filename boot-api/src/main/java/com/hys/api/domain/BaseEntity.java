package com.hys.api.domain;

import java.io.Serializable;


/**
 * 基础信息
 *
 * @author admin
 * @since 2016-01-31 21:42
 */
public class BaseEntity implements Serializable{    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4872597589740542569L;
	private Integer id;    
    private Integer page = 1;    
    private Integer rows = 10;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}