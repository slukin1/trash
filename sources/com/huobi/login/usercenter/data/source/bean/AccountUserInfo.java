package com.huobi.login.usercenter.data.source.bean;

import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.lib.network.inst.bean.InstStateInfo;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.otc.core.bean.UserVO;

public class AccountUserInfo {

    /* renamed from: a  reason: collision with root package name */
    public UserInfoData f75637a;

    /* renamed from: b  reason: collision with root package name */
    public UserKycInfoNew f75638b;

    /* renamed from: c  reason: collision with root package name */
    public UserVO f75639c;

    /* renamed from: d  reason: collision with root package name */
    public UnifyKycInfo f75640d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f75641e;

    /* renamed from: f  reason: collision with root package name */
    public InstStateInfo f75642f;

    /* renamed from: g  reason: collision with root package name */
    public UserOtherInfoData f75643g;

    public boolean a(Object obj) {
        return obj instanceof AccountUserInfo;
    }

    public InstStateInfo b() {
        return this.f75642f;
    }

    public UnifyKycInfo c() {
        return this.f75640d;
    }

    public UserOtherInfoData d() {
        return this.f75643g;
    }

    public UserInfoData e() {
        return this.f75637a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountUserInfo)) {
            return false;
        }
        AccountUserInfo accountUserInfo = (AccountUserInfo) obj;
        if (!accountUserInfo.a(this)) {
            return false;
        }
        UserInfoData e11 = e();
        UserInfoData e12 = accountUserInfo.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        UserKycInfoNew f11 = f();
        UserKycInfoNew f12 = accountUserInfo.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        UserVO g11 = g();
        UserVO g12 = accountUserInfo.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        UnifyKycInfo c11 = c();
        UnifyKycInfo c12 = accountUserInfo.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        if (h() != accountUserInfo.h()) {
            return false;
        }
        InstStateInfo b11 = b();
        InstStateInfo b12 = accountUserInfo.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        UserOtherInfoData d11 = d();
        UserOtherInfoData d12 = accountUserInfo.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public UserKycInfoNew f() {
        return this.f75638b;
    }

    public UserVO g() {
        return this.f75639c;
    }

    public boolean h() {
        return this.f75641e;
    }

    public int hashCode() {
        UserInfoData e11 = e();
        int i11 = 43;
        int hashCode = e11 == null ? 43 : e11.hashCode();
        UserKycInfoNew f11 = f();
        int hashCode2 = ((hashCode + 59) * 59) + (f11 == null ? 43 : f11.hashCode());
        UserVO g11 = g();
        int hashCode3 = (hashCode2 * 59) + (g11 == null ? 43 : g11.hashCode());
        UnifyKycInfo c11 = c();
        int hashCode4 = (((hashCode3 * 59) + (c11 == null ? 43 : c11.hashCode())) * 59) + (h() ? 79 : 97);
        InstStateInfo b11 = b();
        int hashCode5 = (hashCode4 * 59) + (b11 == null ? 43 : b11.hashCode());
        UserOtherInfoData d11 = d();
        int i12 = hashCode5 * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public void i(boolean z11) {
        this.f75641e = z11;
    }

    public void j(InstStateInfo instStateInfo) {
        this.f75642f = instStateInfo;
    }

    public void k(UnifyKycInfo unifyKycInfo) {
        this.f75640d = unifyKycInfo;
    }

    public void l(UserOtherInfoData userOtherInfoData) {
        this.f75643g = userOtherInfoData;
    }

    public void m(UserInfoData userInfoData) {
        this.f75637a = userInfoData;
    }

    public void n(UserKycInfoNew userKycInfoNew) {
        this.f75638b = userKycInfoNew;
    }

    public void o(UserVO userVO) {
        this.f75639c = userVO;
    }

    public String toString() {
        return "AccountUserInfo(userInfoData=" + e() + ", userKycInfoNew=" + f() + ", userVO=" + g() + ", unifyKycInfo=" + c() + ", isInst=" + h() + ", instStateInfo=" + b() + ", userExtInfo=" + d() + ")";
    }
}
