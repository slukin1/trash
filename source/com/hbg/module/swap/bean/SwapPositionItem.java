package com.hbg.module.swap.bean;

import android.content.Context;
import com.google.gson.annotations.Expose;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.module.swap.viewhandler.SwapPositionViewHandler;
import com.huobi.feature.ui.LeverSelectDialogFragment;

public class SwapPositionItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public SwapPosition f37466b;

    /* renamed from: c  reason: collision with root package name */
    public SwapCurrencyInfo f37467c;
    @Expose(serialize = false)

    /* renamed from: d  reason: collision with root package name */
    public transient a f37468d;

    public interface a {
        String a();

        void b(SwapPositionItem swapPositionItem);

        void c(SwapPositionItem swapPositionItem);

        void d(SwapPositionItem swapPositionItem);

        void e(int i11, SwapPositionItem swapPositionItem, int i12, Context context);

        void f(SwapPositionItem swapPositionItem);

        LeverSelectDialogFragment.h g(SwapPositionItem swapPositionItem, SwapPosition swapPosition);
    }

    public boolean a(Object obj) {
        return obj instanceof SwapPositionItem;
    }

    public a c() {
        return this.f37468d;
    }

    public SwapPosition d() {
        return this.f37466b;
    }

    public SwapCurrencyInfo e() {
        return this.f37467c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapPositionItem)) {
            return false;
        }
        SwapPositionItem swapPositionItem = (SwapPositionItem) obj;
        if (!swapPositionItem.a(this)) {
            return false;
        }
        SwapPosition d11 = d();
        SwapPosition d12 = swapPositionItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        SwapCurrencyInfo e11 = e();
        SwapCurrencyInfo e12 = swapPositionItem.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public void f(a aVar) {
        this.f37468d = aVar;
    }

    public void g(SwapPosition swapPosition) {
        this.f37466b = swapPosition;
    }

    public String getViewHandlerName() {
        return SwapPositionViewHandler.class.getName();
    }

    public void h(SwapCurrencyInfo swapCurrencyInfo) {
        this.f37467c = swapCurrencyInfo;
    }

    public int hashCode() {
        SwapPosition d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        SwapCurrencyInfo e11 = e();
        int i12 = (hashCode + 59) * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "SwapPositionItem(position=" + d() + ", swapCurrencyInfo=" + e() + ", clickListener=" + c() + ")";
    }
}
