package com.hys.api.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CountryVo extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -3623625620809619472L;
    private String countryname;
    private String countrycode;


    public String getCountryname() {
        return countryname;
    }


    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }


    public String getCountrycode() {
        return countrycode;
    }


    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}