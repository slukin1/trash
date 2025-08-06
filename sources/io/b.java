package io;

import com.huobi.menu.viewhandler.CommonIconTextMenuItemHandler;
import ho.a;

public class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public int f84276d;

    /* renamed from: e  reason: collision with root package name */
    public String f84277e;

    public b(int i11, int i12, String str, a aVar) {
        super(i11, aVar);
        j(str);
        i(i12);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!bVar.f(this) || g() != bVar.g()) {
            return false;
        }
        String h11 = h();
        String h12 = bVar.h();
        return h11 != null ? h11.equals(h12) : h12 == null;
    }

    public boolean f(Object obj) {
        return obj instanceof b;
    }

    public int g() {
        return this.f84276d;
    }

    public String getViewHandlerName() {
        return CommonIconTextMenuItemHandler.class.getName();
    }

    public String h() {
        return this.f84277e;
    }

    public int hashCode() {
        String h11 = h();
        return ((g() + 59) * 59) + (h11 == null ? 43 : h11.hashCode());
    }

    public void i(int i11) {
        this.f84276d = i11;
    }

    public void j(String str) {
        this.f84277e = str;
    }

    public String toString() {
        return "CommonIconTextMenuItem(imageResId=" + g() + ", text=" + h() + ")";
    }
}
