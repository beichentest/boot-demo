package com.hys.boot.provider.model;

import java.io.Serializable;

public class City extends BaseEntity implements Serializable{   

    /**
	 * 
	 */
	private static final long serialVersionUID = 1661221680954391855L;

	private String name;

    private String state;

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
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }
}