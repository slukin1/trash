package ba;

import com.hbg.lib.widgets.dialog.viewhander.CommonListTipsItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f70961b;

    /* renamed from: c  reason: collision with root package name */
    public int f70962c;

    /* renamed from: d  reason: collision with root package name */
    public String f70963d;

    /* renamed from: e  reason: collision with root package name */
    public C0785a f70964e;

    /* renamed from: ba.a$a  reason: collision with other inner class name */
    public interface C0785a {
        void a(a aVar);
    }

    public a(int i11, int i12, String str, C0785a aVar) {
        this.f70961b = i11;
        this.f70962c = i12;
        this.f70963d = str;
        this.f70964e = aVar;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public C0785a c() {
        return this.f70964e;
    }

    public int d() {
        return this.f70962c;
    }

    public String e() {
        return this.f70963d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this) || f() != aVar.f() || d() != aVar.d()) {
            return false;
        }
        String e11 = e();
        String e12 = aVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        C0785a c11 = c();
        C0785a c12 = aVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public int f() {
        return this.f70961b;
    }

    public String getViewHandlerName() {
        return CommonListTipsItemHandler.class.getName();
    }

    public int hashCode() {
        int f11 = ((f() + 59) * 59) + d();
        String e11 = e();
        int i11 = 43;
        int hashCode = (f11 * 59) + (e11 == null ? 43 : e11.hashCode());
        C0785a c11 = c();
        int i12 = hashCode * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "CommonListTipsItem(type=" + f() + ", drawableId=" + d() + ", text=" + e() + ", callback=" + c() + ")";
    }
}
