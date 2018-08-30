package com.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="jef_user")
public class JefUser {

    @Id
    @GeneratedValue
    @Column
    private Integer userId;
    @Column
    private String userName;
    @Column
    private String account;
    @Column
    private String password;
    @Column
    private Date createAt;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
