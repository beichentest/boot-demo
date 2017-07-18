package com.hys.boot.provider.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Country extends BaseEntity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3623625620809619472L;

	/**
     * ����
     */
    private String countryname;

    /**
     * ����
     */
    private String countrycode;

    /**
     * ��ȡ����
     *
     * @return countryname - ����
     */
    public String getCountryname() {
        return countryname;
    }

    /**
     * ��������
     *
     * @param countryname ����
     */
    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    /**
     * ��ȡ����
     *
     * @return countrycode - ����
     */
    public String getCountrycode() {
        return countrycode;
    }

    /**
     * ���ô���
     *
     * @param countrycode ����
     */
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}