package t9;

import com.hbg.lib.widgets.adapter.viewpager.CommonDividerItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f76568b;

    /* renamed from: c  reason: collision with root package name */
    public int f76569c;

    /* renamed from: d  reason: collision with root package name */
    public int f76570d;

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public int c() {
        return this.f76568b;
    }

    public int d() {
        return this.f76569c;
    }

    public int e() {
        return this.f76570d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return aVar.a(this) && c() == aVar.c() && d() == aVar.d() && e() == aVar.e();
    }

    public String getViewHandlerName() {
        return CommonDividerItemHandler.class.getName();
    }

    public int hashCode() {
        return ((((c() + 59) * 59) + d()) * 59) + e();
    }

    public String toString() {
        return "CommonDividerItem(bgColor=" + c() + ", bgRes=" + d() + ", height=" + e() + ")";
    }
}
