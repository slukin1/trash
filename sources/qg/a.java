package qg;

import android.content.Context;
import com.huobi.account.viewhandler.KeepLoginItemHolder;
import tg.f;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f47737b;

    /* renamed from: c  reason: collision with root package name */
    public int f47738c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47739d;

    /* renamed from: e  reason: collision with root package name */
    public C0582a f47740e;

    /* renamed from: qg.a$a  reason: collision with other inner class name */
    public interface C0582a {
        void xa(a aVar);
    }

    public a(int i11, int i12, boolean z11, C0582a aVar) {
        this.f47737b = i11;
        this.f47738c = i12;
        this.f47739d = z11;
        this.f47740e = aVar;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public C0582a c() {
        return this.f47740e;
    }

    public int d() {
        return this.f47738c;
    }

    public String e(Context context) {
        return f.d(context, this.f47737b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this) || f() != aVar.f() || d() != aVar.d() || h() != aVar.h()) {
            return false;
        }
        C0582a c11 = c();
        C0582a c12 = aVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public int f() {
        return this.f47737b;
    }

    public boolean g() {
        return this.f47737b == this.f47738c;
    }

    public String getViewHandlerName() {
        return KeepLoginItemHolder.class.getName();
    }

    public boolean h() {
        return this.f47739d;
    }

    public int hashCode() {
        int f11 = ((((f() + 59) * 59) + d()) * 59) + (h() ? 79 : 97);
        C0582a c11 = c();
        return (f11 * 59) + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "KeepLoginItem(type=" + f() + ", currentType=" + d() + ", isGaBind=" + h() + ", callback=" + c() + ")";
    }
}
