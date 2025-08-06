package hr;

import com.hbg.lib.widgets.CommonSwitchButton;
import com.huobi.setting.viewhandler.SettingSwitchItemHandler;

public class g implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f84208b;

    /* renamed from: c  reason: collision with root package name */
    public String f84209c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84210d;

    /* renamed from: e  reason: collision with root package name */
    public a f84211e;

    public interface a {
        void a(g gVar, CommonSwitchButton commonSwitchButton);
    }

    public boolean a(Object obj) {
        return obj instanceof g;
    }

    public a c() {
        return this.f84211e;
    }

    public String d() {
        return this.f84209c;
    }

    public int e() {
        return this.f84208b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (!gVar.a(this) || e() != gVar.e()) {
            return false;
        }
        String d11 = d();
        String d12 = gVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        if (f() != gVar.f()) {
            return false;
        }
        a c11 = c();
        a c12 = gVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public boolean f() {
        return this.f84210d;
    }

    public String getViewHandlerName() {
        return SettingSwitchItemHandler.class.getName();
    }

    public int hashCode() {
        String d11 = d();
        int i11 = 43;
        int e11 = ((((e() + 59) * 59) + (d11 == null ? 43 : d11.hashCode())) * 59) + (f() ? 79 : 97);
        a c11 = c();
        int i12 = e11 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "SettingSwitchItem(type=" + e() + ", title=" + d() + ", checked=" + f() + ", callback=" + c() + ")";
    }
}
