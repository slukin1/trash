package yd;

import android.view.View;
import com.hbg.module.kline.draw.LineSizeEnum;
import com.hbg.module.kline.draw.holder.LineSizeHolder;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public LineSizeEnum f26380b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26381c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f26382d;

    public a(LineSizeEnum lineSizeEnum, boolean z11, View.OnClickListener onClickListener) {
        this.f26380b = lineSizeEnum;
        this.f26381c = z11;
        this.f26382d = onClickListener;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public View.OnClickListener c() {
        return this.f26382d;
    }

    public LineSizeEnum d() {
        return this.f26380b;
    }

    public boolean e() {
        return this.f26381c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this)) {
            return false;
        }
        LineSizeEnum d11 = d();
        LineSizeEnum d12 = aVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        if (e() != aVar.e()) {
            return false;
        }
        View.OnClickListener c11 = c();
        View.OnClickListener c12 = aVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(boolean z11) {
        this.f26381c = z11;
    }

    public String getViewHandlerName() {
        return LineSizeHolder.class.getName();
    }

    public int hashCode() {
        LineSizeEnum d11 = d();
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
        return "LineSizeBean(size=" + d() + ", selected=" + e() + ", onClickListener=" + c() + ")";
    }
}
