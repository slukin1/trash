package vk;

import android.view.View;
import com.huobi.finance.viewhandler.AccountChooseItemViewHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f47971b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f47972c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47973d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f47974e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47975f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47976g = false;

    public a(int i11, View.OnClickListener onClickListener) {
        this.f47971b = i11;
        this.f47972c = onClickListener;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public View.OnClickListener c() {
        return this.f47972c;
    }

    public int d() {
        return this.f47971b;
    }

    public int e() {
        return this.f47974e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this) || d() != aVar.d()) {
            return false;
        }
        View.OnClickListener c11 = c();
        View.OnClickListener c12 = aVar.c();
        if (c11 != null ? c11.equals(c12) : c12 == null) {
            return h() == aVar.h() && e() == aVar.e() && g() == aVar.g() && f() == aVar.f();
        }
        return false;
    }

    public boolean f() {
        return this.f47976g;
    }

    public boolean g() {
        return this.f47975f;
    }

    public String getViewHandlerName() {
        return AccountChooseItemViewHandler.class.getName();
    }

    public boolean h() {
        return this.f47973d;
    }

    public int hashCode() {
        View.OnClickListener c11 = c();
        int i11 = 79;
        int d11 = (((((((((d() + 59) * 59) + (c11 == null ? 43 : c11.hashCode())) * 59) + (h() ? 79 : 97)) * 59) + e()) * 59) + (g() ? 79 : 97)) * 59;
        if (!f()) {
            i11 = 97;
        }
        return d11 + i11;
    }

    public void i(boolean z11) {
        this.f47975f = z11;
    }

    public String toString() {
        return "AccountChooseItem(titleResId=" + d() + ", onClickListener=" + c() + ", showArrow=" + h() + ", viewType=" + e() + ", isSelect=" + g() + ", isDisable=" + f() + ")";
    }

    public a(int i11, View.OnClickListener onClickListener, boolean z11) {
        this.f47971b = i11;
        this.f47972c = onClickListener;
        this.f47973d = z11;
    }

    public a(int i11, boolean z11) {
        this.f47971b = i11;
        this.f47976g = z11;
    }

    public a(int i11, int i12) {
        this.f47971b = i11;
        this.f47974e = i12;
    }
}
