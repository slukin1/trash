package com.huobi.finance.bean;

import al.y;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.bean.HuoPayAccountData;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import java.util.List;

public class WithdrawInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f45394a;

    /* renamed from: b  reason: collision with root package name */
    public String f45395b;

    /* renamed from: c  reason: collision with root package name */
    public UserSecurityInfoData f45396c;

    /* renamed from: d  reason: collision with root package name */
    public SecurityStrategySet f45397d;

    /* renamed from: e  reason: collision with root package name */
    public PreWithdrawData f45398e;

    /* renamed from: f  reason: collision with root package name */
    public List<ChainInfo> f45399f;

    /* renamed from: g  reason: collision with root package name */
    public List<InnerWithdrawAddress> f45400g;

    /* renamed from: h  reason: collision with root package name */
    public HuoPayAccountData f45401h;

    public List<InnerWithdrawAddress> a() {
        return this.f45400g;
    }

    public String b() {
        return this.f45395b;
    }

    public InnerWithdrawAddress c() {
        List<InnerWithdrawAddress> list = this.f45400g;
        if (list == null || list.size() == 0) {
            return null;
        }
        for (InnerWithdrawAddress next : this.f45400g) {
            if (y.a(next)) {
                return next;
            }
        }
        return this.f45400g.get(0);
    }

    public HuoPayAccountData d() {
        return this.f45401h;
    }

    public PreWithdrawData e() {
        return this.f45398e;
    }

    public SecurityStrategySet f() {
        return this.f45397d;
    }

    public boolean g() {
        HuoPayAccountData huoPayAccountData = this.f45401h;
        return huoPayAccountData != null && huoPayAccountData.isAvailable();
    }

    public void h(List<InnerWithdrawAddress> list) {
        this.f45400g = list;
    }

    public void i(String str) {
        this.f45395b = str;
    }

    public void j(List<ChainInfo> list) {
        this.f45399f = list;
    }

    public void k(String str) {
        this.f45394a = str;
    }

    public void l(PreWithdrawData preWithdrawData) {
        this.f45398e = preWithdrawData;
    }

    public void m(UserSecurityInfoData userSecurityInfoData) {
        this.f45396c = userSecurityInfoData;
    }

    public void n(SecurityStrategySet securityStrategySet) {
        this.f45397d = securityStrategySet;
    }
}
