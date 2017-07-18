package com.hys.boot.provider.model;

import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * �û���
     */
    private String username;

    /**
     * ����
     */
    private String password;

    /**
     * �û�����
     */
    private String usertype;

    /**
     * �Ƿ����
     */
    private Integer enabled;

    /**
     * ��ʵ����
     */
    private String realname;

    /**
     * QQ
     */
    private String qq;

    private String email;

    /**
     * ��ϵ�绰
     */
    private String tel;

    /**
     * @return Id
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
     * ��ȡ�û���
     *
     * @return username - �û���
     */
    public String getUsername() {
        return username;
    }

    /**
     * �����û���
     *
     * @param username �û���
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * ��ȡ����
     *
     * @return password - ����
     */
    public String getPassword() {
        return password;
    }

    /**
     * ��������
     *
     * @param password ����
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ��ȡ�û�����
     *
     * @return usertype - �û�����
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * �����û�����
     *
     * @param usertype �û�����
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    /**
     * ��ȡ�Ƿ����
     *
     * @return enabled - �Ƿ����
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * �����Ƿ����
     *
     * @param enabled �Ƿ����
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    /**
     * ��ȡ��ʵ����
     *
     * @return realname - ��ʵ����
     */
    public String getRealname() {
        return realname;
    }

    /**
     * ������ʵ����
     *
     * @param realname ��ʵ����
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * ��ȡQQ
     *
     * @return qq - QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * ����QQ
     *
     * @param qq QQ
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * ��ȡ��ϵ�绰
     *
     * @return tel - ��ϵ�绰
     */
    public String getTel() {
        return tel;
    }

    /**
     * ������ϵ�绰
     *
     * @param tel ��ϵ�绰
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
}