package com.huobi.otc.bean;

import com.hbg.lib.network.otc.core.bean.UserVO;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;

public class UserSecuritySetData {
    private SecurityStrategySet securityStrategySet;
    private UserSecurityInfoData userSecurityInfoData;
    private UserVO userVO;

    public SecurityStrategySet getSecurityStrategySet() {
        return this.securityStrategySet;
    }

    public UserSecurityInfoData getUserSecurityInfoData() {
        return this.userSecurityInfoData;
    }

    public UserVO getUserVO() {
        return this.userVO;
    }

    public void setSecurityStrategySet(SecurityStrategySet securityStrategySet2) {
        this.securityStrategySet = securityStrategySet2;
    }

    public void setUserSecurityInfoData(UserSecurityInfoData userSecurityInfoData2) {
        this.userSecurityInfoData = userSecurityInfoData2;
    }

    public void setUserVO(UserVO userVO2) {
        this.userVO = userVO2;
    }
}
