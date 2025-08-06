package com.huobi.login.usercenter.data.source.bean;

import java.io.Serializable;

public class SecurityStrategySet implements Serializable {
    private static final long serialVersionUID = 8290048291758269599L;
    private SecurityStrategy setting;

    public SecurityStrategy getSetting() {
        return this.setting;
    }

    public void setSetting(SecurityStrategy securityStrategy) {
        this.setting = securityStrategy;
    }
}
