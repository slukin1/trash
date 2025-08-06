package gq;

import android.view.View;
import com.huobi.points.viewhandler.PointsBuyCurrencyViewHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public String f84169b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f84170c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84171d;

    public a(String str, View.OnClickListener onClickListener, boolean z11) {
        this.f84169b = str;
        this.f84170c = onClickListener;
        this.f84171d = z11;
    }

    public String a() {
        return this.f84169b;
    }

    public View.OnClickListener c() {
        return this.f84170c;
    }

    public boolean d() {
        return this.f84171d;
    }

    public void e(boolean z11) {
        this.f84171d = z11;
    }

    public String getViewHandlerName() {
        return PointsBuyCurrencyViewHandler.class.getName();
    }
}
