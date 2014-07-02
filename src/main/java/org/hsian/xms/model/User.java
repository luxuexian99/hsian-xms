package org.hsian.xms.model;

import org.hsian.xms.model.common.AbstractPo;

/**
 * Created by Hsian on 14-6-22.
 */
public class User extends AbstractPo {

    private String userName;

    //@Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    //@Column(name = "password", nullable = false, length = 50)
    private String password;

    public User() {}

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
