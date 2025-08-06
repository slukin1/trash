package yd;

import android.view.View;
import com.hbg.module.kline.draw.LineColorEnum;
import com.hbg.module.kline.draw.holder.PaletteHolder;
import s9.a;

public class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public LineColorEnum f26386b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26387c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f26388d;

    public c(LineColorEnum lineColorEnum, boolean z11, View.OnClickListener onClickListener) {
        this.f26386b = lineColorEnum;
        this.f26387c = z11;
        this.f26388d = onClickListener;
    }

    public boolean a(Object obj) {
        return obj instanceof c;
    }

    public LineColorEnum c() {
        return this.f26386b;
    }

    public View.OnClickListener d() {
        return this.f26388d;
    }

    public boolean e() {
        return this.f26387c;
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
        LineColorEnum c11 = c();
        LineColorEnum c12 = cVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        if (e() != cVar.e()) {
            return false;
        }
        View.OnClickListener d11 = d();
        View.OnClickListener d12 = cVar.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public void f(boolean z11) {
        this.f26387c = z11;
    }

    public String getViewHandlerName() {
        return PaletteHolder.class.getName();
    }

    public int hashCode() {
        LineColorEnum c11 = c();
        int i11 = 43;
        int hashCode = (((c11 == null ? 43 : c11.hashCode()) + 59) * 59) + (e() ? 79 : 97);
        View.OnClickListener d11 = d();
        int i12 = hashCode * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "PaletteBean(color=" + c() + ", selected=" + e() + ", onClickListener=" + d() + ")";
    }
}
