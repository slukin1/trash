package vk;

import android.view.View;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f47978a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f47979b;

    public c(String str, View.OnClickListener onClickListener) {
        this.f47978a = str;
        this.f47979b = onClickListener;
    }

    public boolean a(Object obj) {
        return obj instanceof c;
    }

    public String b() {
        return this.f47978a;
    }

    public View.OnClickListener c() {
        return this.f47979b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!cVar.a(this)) {
            return false;
        }
        String b11 = b();
        String b12 = cVar.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        View.OnClickListener c11 = c();
        View.OnClickListener c12 = cVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public int hashCode() {
        String b11 = b();
        int i11 = 43;
        int hashCode = b11 == null ? 43 : b11.hashCode();
        View.OnClickListener c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "AssetHeaderAction(name=" + b() + ", onClickListener=" + c() + ")";
    }
}
