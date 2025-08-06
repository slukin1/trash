package bs;

import com.hbg.lib.widgets.CommonSwitchButton;
import com.huobi.staring.viewhandler.RemindSettingListItemHandler;

public class b implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public long f77033b;

    /* renamed from: c  reason: collision with root package name */
    public String f77034c;

    /* renamed from: d  reason: collision with root package name */
    public String f77035d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f77036e;

    /* renamed from: f  reason: collision with root package name */
    public a f77037f;

    public interface a {
        void a(b bVar, CommonSwitchButton commonSwitchButton);
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public a c() {
        return this.f77037f;
    }

    public String d() {
        return this.f77035d;
    }

    public String e() {
        return this.f77034c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!bVar.a(this) || f() != bVar.f()) {
            return false;
        }
        String e11 = e();
        String e12 = bVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = bVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        if (g() != bVar.g()) {
            return false;
        }
        a c11 = c();
        a c12 = bVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public long f() {
        return this.f77033b;
    }

    public boolean g() {
        return this.f77036e;
    }

    public String getViewHandlerName() {
        return RemindSettingListItemHandler.class.getName();
    }

    public int hashCode() {
        long f11 = f();
        String e11 = e();
        int i11 = 43;
        int hashCode = ((((int) (f11 ^ (f11 >>> 32))) + 59) * 59) + (e11 == null ? 43 : e11.hashCode());
        String d11 = d();
        int hashCode2 = (((hashCode * 59) + (d11 == null ? 43 : d11.hashCode())) * 59) + (g() ? 79 : 97);
        a c11 = c();
        int i12 = hashCode2 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "RemindSettingListItem(type=" + f() + ", title=" + e() + ", desc=" + d() + ", checked=" + g() + ", callback=" + c() + ")";
    }
}
