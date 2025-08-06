package com.huobi.login.usercenter.data.source.bean;

import com.hbg.lib.network.otc.core.bean.UserVO;

public class SecuritySetData {

    /* renamed from: a  reason: collision with root package name */
    public SecurityStrategySet f75656a;

    /* renamed from: b  reason: collision with root package name */
    public UserSecurityInfoData f75657b;

    /* renamed from: c  reason: collision with root package name */
    public UserSecurityLoginListData f75658c;

    /* renamed from: d  reason: collision with root package name */
    public UserVO f75659d;

    public SecurityStrategySet a() {
        return this.f75656a;
    }

    public UserSecurityInfoData b() {
        return this.f75657b;
    }

    public UserSecurityLoginListData c() {
        return this.f75658c;
    }

    public UserVO d() {
        return this.f75659d;
    }

    public void e(SecurityStrategySet securityStrategySet) {
        this.f75656a = securityStrategySet;
    }

    public void f(UserSecurityInfoData userSecurityInfoData) {
        this.f75657b = userSecurityInfoData;
    }

    public void g(UserSecurityLoginListData userSecurityLoginListData) {
        this.f75658c = userSecurityLoginListData;
    }

    public void h(UserVO userVO) {
        this.f75659d = userVO;
    }
}
