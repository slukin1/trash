package io;

import com.huobi.menu.viewhandler.CommonMenuItemHandler;
import ho.a;

public class c extends a {

    /* renamed from: d  reason: collision with root package name */
    public int f84278d;

    public c(int i11, int i12, a aVar) {
        super(i11, aVar);
        h(i12);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.f(this) && g() == cVar.g();
    }

    public boolean f(Object obj) {
        return obj instanceof c;
    }

    public int g() {
        return this.f84278d;
    }

    public String getViewHandlerName() {
        return CommonMenuItemHandler.class.getName();
    }

    public void h(int i11) {
        this.f84278d = i11;
    }

    public int hashCode() {
        return 59 + g();
    }

    public String toString() {
        return "CommonMenuItem(imageResId=" + g() + ")";
    }
}
