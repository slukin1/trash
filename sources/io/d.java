package io;

import com.huobi.menu.viewhandler.TextMenuItemHandler;

public class d extends c {

    /* renamed from: e  reason: collision with root package name */
    public String f84279e;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!dVar.f(this)) {
            return false;
        }
        String i11 = i();
        String i12 = dVar.i();
        return i11 != null ? i11.equals(i12) : i12 == null;
    }

    public boolean f(Object obj) {
        return obj instanceof d;
    }

    public String getViewHandlerName() {
        return TextMenuItemHandler.class.getName();
    }

    public int hashCode() {
        String i11 = i();
        return 59 + (i11 == null ? 43 : i11.hashCode());
    }

    public String i() {
        return this.f84279e;
    }

    public String toString() {
        return "TextMenuItem(text=" + i() + ")";
    }
}
