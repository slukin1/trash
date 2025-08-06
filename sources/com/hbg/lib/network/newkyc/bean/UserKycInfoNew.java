package com.hbg.lib.network.newkyc.bean;

import java.io.Serializable;

public class UserKycInfoNew implements Serializable {
    private AuthInfoNew auth_info;
    private ForceInfoNew force_info;
    private UserInfoNew user_info;

    public AuthInfoNew getAuth_info() {
        return this.auth_info;
    }

    public ForceInfoNew getForce_info() {
        return this.force_info;
    }

    public UserInfoNew getUser_info() {
        return this.user_info;
    }

    public void setAuth_info(AuthInfoNew authInfoNew) {
        this.auth_info = authInfoNew;
    }

    public void setForce_info(ForceInfoNew forceInfoNew) {
        this.force_info = forceInfoNew;
    }

    public void setUser_info(UserInfoNew userInfoNew) {
        this.user_info = userInfoNew;
    }
}
