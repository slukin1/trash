package yd;

import android.view.View;
import com.hbg.module.kline.draw.LineStyleEnum;
import com.hbg.module.kline.draw.holder.LineStyleHolder;
import s9.a;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public LineStyleEnum f26383b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26384c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f26385d;

    public b(LineStyleEnum lineStyleEnum, boolean z11, View.OnClickListener onClickListener) {
        this.f26383b = lineStyleEnum;
        this.f26384c = z11;
        this.f26385d = onClickListener;
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public View.OnClickListener c() {
        return this.f26385d;
    }

    public LineStyleEnum d() {
        return this.f26383b;
    }

    public boolean e() {
        return this.f26384c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!bVar.a(this)) {
            return false;
        }
        LineStyleEnum d11 = d();
        LineStyleEnum d12 = bVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        if (e() != bVar.e()) {
            return false;
        }
        View.OnClickListener c11 = c();
        View.OnClickListener c12 = bVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(boolean z11) {
        this.f26384c = z11;
    }

    public String getViewHandlerName() {
        return LineStyleHolder.class.getName();
    }

    public int hashCode() {
        LineStyleEnum d11 = d();
        int i11 = 43;
        int hashCode = (((d11 == null ? 43 : d11.hashCode()) + 59) * 59) + (e() ? 79 : 97);
        View.OnClickListener c11 = c();
        int i12 = hashCode * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "LineStyleBean(style=" + d() + ", selected=" + e() + ", onClickListener=" + c() + ")";
    }
}
