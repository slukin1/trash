package t9;

import com.hbg.lib.widgets.adapter.viewpager.CommonOffsetDividerItemHandler;
import s9.a;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f76571b;

    /* renamed from: c  reason: collision with root package name */
    public int f76572c;

    /* renamed from: d  reason: collision with root package name */
    public int f76573d;

    /* renamed from: e  reason: collision with root package name */
    public int f76574e;

    /* renamed from: f  reason: collision with root package name */
    public int f76575f;

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public int c() {
        return this.f76572c;
    }

    public int d() {
        return this.f76575f;
    }

    public int e() {
        return this.f76573d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return bVar.a(this) && f() == bVar.f() && c() == bVar.c() && e() == bVar.e() && g() == bVar.g() && d() == bVar.d();
    }

    public int f() {
        return this.f76571b;
    }

    public int g() {
        return this.f76574e;
    }

    public String getViewHandlerName() {
        return CommonOffsetDividerItemHandler.class.getName();
    }

    public int hashCode() {
        return ((((((((f() + 59) * 59) + c()) * 59) + e()) * 59) + g()) * 59) + d();
    }

    public String toString() {
        return "CommonOffsetDividerItem(lineColor=" + f() + ", bgColor=" + c() + ", height=" + e() + ", startOffset=" + g() + ", endOffset=" + d() + ")";
    }
}
