package com.huobi.trade.bean;

import android.view.View;
import com.huobi.trade.handler.TradeSymbolChangeViewHandler;
import s9.a;

public class TradeSymbolChangeItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f81963b;

    /* renamed from: c  reason: collision with root package name */
    public String f81964c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f81965d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f81966e;

    public boolean a(Object obj) {
        return obj instanceof TradeSymbolChangeItem;
    }

    public View.OnClickListener c() {
        return this.f81966e;
    }

    public String d() {
        return this.f81963b;
    }

    public String e() {
        return this.f81964c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeSymbolChangeItem)) {
            return false;
        }
        TradeSymbolChangeItem tradeSymbolChangeItem = (TradeSymbolChangeItem) obj;
        if (!tradeSymbolChangeItem.a(this)) {
            return false;
        }
        String d11 = d();
        String d12 = tradeSymbolChangeItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = tradeSymbolChangeItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        if (f() != tradeSymbolChangeItem.f()) {
            return false;
        }
        View.OnClickListener c11 = c();
        View.OnClickListener c12 = tradeSymbolChangeItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public boolean f() {
        return this.f81965d;
    }

    public void g(View.OnClickListener onClickListener) {
        this.f81966e = onClickListener;
    }

    public String getViewHandlerName() {
        return TradeSymbolChangeViewHandler.class.getName();
    }

    public void h(boolean z11) {
        this.f81965d = z11;
    }

    public int hashCode() {
        String d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        String e11 = e();
        int hashCode2 = ((((hashCode + 59) * 59) + (e11 == null ? 43 : e11.hashCode())) * 59) + (f() ? 79 : 97);
        View.OnClickListener c11 = c();
        int i12 = hashCode2 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public void i(String str) {
        this.f81963b = str;
    }

    public void j(String str) {
        this.f81964c = str;
    }

    public String toString() {
        return "TradeSymbolChangeItem(symbol=" + d() + ", symbolName=" + e() + ", isSelected=" + f() + ", onClickListener=" + c() + ")";
    }
}
