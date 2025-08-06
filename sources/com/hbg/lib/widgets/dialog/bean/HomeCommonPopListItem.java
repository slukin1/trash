package com.hbg.lib.widgets.dialog.bean;

import android.text.TextUtils;
import com.hbg.lib.widgets.dialog.viewhander.CommonHomePopListItemHandler;

public class HomeCommonPopListItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f71937b;

    /* renamed from: c  reason: collision with root package name */
    public int f71938c;

    /* renamed from: d  reason: collision with root package name */
    public String f71939d;

    /* renamed from: e  reason: collision with root package name */
    public String f71940e;

    /* renamed from: f  reason: collision with root package name */
    public a f71941f;

    public interface a {
        void a(HomeCommonPopListItem homeCommonPopListItem);
    }

    public HomeCommonPopListItem() {
    }

    public boolean a(Object obj) {
        return obj instanceof HomeCommonPopListItem;
    }

    public a c() {
        return this.f71941f;
    }

    public String d() {
        return this.f71939d;
    }

    public int e() {
        return this.f71938c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HomeCommonPopListItem)) {
            return false;
        }
        HomeCommonPopListItem homeCommonPopListItem = (HomeCommonPopListItem) obj;
        if (!homeCommonPopListItem.a(this) || g() != homeCommonPopListItem.g() || e() != homeCommonPopListItem.e()) {
            return false;
        }
        String d11 = d();
        String d12 = homeCommonPopListItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = homeCommonPopListItem.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = homeCommonPopListItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String f() {
        return this.f71940e;
    }

    public int g() {
        return this.f71937b;
    }

    public String getViewHandlerName() {
        return CommonHomePopListItemHandler.class.getName();
    }

    public boolean h() {
        return !TextUtils.isEmpty(this.f71940e);
    }

    public int hashCode() {
        int g11 = ((g() + 59) * 59) + e();
        String d11 = d();
        int i11 = 43;
        int hashCode = (g11 * 59) + (d11 == null ? 43 : d11.hashCode());
        String f11 = f();
        int hashCode2 = (hashCode * 59) + (f11 == null ? 43 : f11.hashCode());
        a c11 = c();
        int i12 = hashCode2 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "HomeCommonPopListItem(type=" + g() + ", iconRes=" + e() + ", contentText=" + d() + ", tipsText=" + f() + ", callback=" + c() + ")";
    }

    public HomeCommonPopListItem(int i11, int i12, String str, String str2, a aVar) {
        this.f71937b = i11;
        this.f71938c = i12;
        this.f71939d = str;
        this.f71940e = str2;
        this.f71941f = aVar;
    }
}
