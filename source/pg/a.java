package pg;

import com.hbg.lib.core.util.NightHelper;
import com.huobi.account.handler.PersonalActivityHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public String f47695b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47696c;

    /* renamed from: d  reason: collision with root package name */
    public String f47697d;

    /* renamed from: e  reason: collision with root package name */
    public String f47698e;

    /* renamed from: f  reason: collision with root package name */
    public String f47699f;

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public boolean c() {
        return this.f47696c;
    }

    public String d() {
        return this.f47699f;
    }

    public String e() {
        if (NightHelper.e().g()) {
            return this.f47698e;
        }
        return this.f47697d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this)) {
            return false;
        }
        String g11 = g();
        String g12 = aVar.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        if (h() != aVar.h()) {
            return false;
        }
        String e11 = e();
        String e12 = aVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = aVar.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = aVar.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public String f() {
        return this.f47698e;
    }

    public String g() {
        return this.f47695b;
    }

    public String getViewHandlerName() {
        return PersonalActivityHandler.class.getName();
    }

    public boolean h() {
        return this.f47696c;
    }

    public int hashCode() {
        String g11 = g();
        int i11 = 43;
        int hashCode = (((g11 == null ? 43 : g11.hashCode()) + 59) * 59) + (h() ? 79 : 97);
        String e11 = e();
        int hashCode2 = (hashCode * 59) + (e11 == null ? 43 : e11.hashCode());
        String f11 = f();
        int hashCode3 = (hashCode2 * 59) + (f11 == null ? 43 : f11.hashCode());
        String d11 = d();
        int i12 = hashCode3 * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "PersonalActivityBean(title=" + g() + ", state=" + h() + ", logo=" + e() + ", nightLogo=" + f() + ", jumpUrl=" + d() + ")";
    }
}
