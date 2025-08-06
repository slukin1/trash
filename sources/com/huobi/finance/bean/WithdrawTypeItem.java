package com.huobi.finance.bean;

import com.hbg.lib.network.pro.core.bean.HuoPayAccountData;
import com.huobi.finance.viewhandler.WithdrawTypeViewHandler;

public class WithdrawTypeItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public WithdrawType f45402b;

    /* renamed from: c  reason: collision with root package name */
    public String f45403c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45404d;

    /* renamed from: e  reason: collision with root package name */
    public HuoPayAccountData f45405e;

    /* renamed from: f  reason: collision with root package name */
    public InnerWithdrawAddress f45406f;

    /* renamed from: g  reason: collision with root package name */
    public a f45407g;

    public enum WithdrawType {
        NORMAL,
        EOS,
        HUO_PAY
    }

    public interface a {
        void a(int i11, WithdrawTypeItem withdrawTypeItem);

        boolean b(int i11, WithdrawTypeItem withdrawTypeItem);
    }

    public boolean a(Object obj) {
        return obj instanceof WithdrawTypeItem;
    }

    public InnerWithdrawAddress c() {
        return this.f45406f;
    }

    public a d() {
        return this.f45407g;
    }

    public String e() {
        return this.f45403c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WithdrawTypeItem)) {
            return false;
        }
        WithdrawTypeItem withdrawTypeItem = (WithdrawTypeItem) obj;
        if (!withdrawTypeItem.a(this)) {
            return false;
        }
        WithdrawType g11 = g();
        WithdrawType g12 = withdrawTypeItem.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = withdrawTypeItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        if (h() != withdrawTypeItem.h()) {
            return false;
        }
        HuoPayAccountData f11 = f();
        HuoPayAccountData f12 = withdrawTypeItem.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        InnerWithdrawAddress c11 = c();
        InnerWithdrawAddress c12 = withdrawTypeItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        a d11 = d();
        a d12 = withdrawTypeItem.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public HuoPayAccountData f() {
        return this.f45405e;
    }

    public WithdrawType g() {
        return this.f45402b;
    }

    public String getViewHandlerName() {
        return WithdrawTypeViewHandler.class.getName();
    }

    public boolean h() {
        return this.f45404d;
    }

    public int hashCode() {
        WithdrawType g11 = g();
        int i11 = 43;
        int hashCode = g11 == null ? 43 : g11.hashCode();
        String e11 = e();
        int hashCode2 = ((((hashCode + 59) * 59) + (e11 == null ? 43 : e11.hashCode())) * 59) + (h() ? 79 : 97);
        HuoPayAccountData f11 = f();
        int hashCode3 = (hashCode2 * 59) + (f11 == null ? 43 : f11.hashCode());
        InnerWithdrawAddress c11 = c();
        int hashCode4 = (hashCode3 * 59) + (c11 == null ? 43 : c11.hashCode());
        a d11 = d();
        int i12 = hashCode4 * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public void i(a aVar) {
        this.f45407g = aVar;
    }

    public void j(String str) {
        this.f45403c = str;
    }

    public void k(boolean z11) {
        this.f45404d = z11;
    }

    public void l(WithdrawType withdrawType) {
        this.f45402b = withdrawType;
    }

    public String toString() {
        return "WithdrawTypeItem(type=" + g() + ", displayName=" + e() + ", isSelected=" + h() + ", huoPayAccountData=" + f() + ", address=" + c() + ", callback=" + d() + ")";
    }
}
