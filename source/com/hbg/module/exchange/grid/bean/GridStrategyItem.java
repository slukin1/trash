package com.hbg.module.exchange.grid.bean;

import android.content.Context;
import com.hbg.lib.network.hbg.grid.bean.GridStrategy;
import com.hbg.module.exchange.grid.handler.GridStrategyViewHandler;

public class GridStrategyItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public GridStrategy f19442b;

    /* renamed from: c  reason: collision with root package name */
    public a f19443c;

    public interface a {
        void a(GridStrategyItem gridStrategyItem, Context context);

        void b(String str);

        void c(GridStrategyItem gridStrategyItem, Context context);
    }

    public boolean a(Object obj) {
        return obj instanceof GridStrategyItem;
    }

    public a c() {
        return this.f19443c;
    }

    public GridStrategy d() {
        return this.f19442b;
    }

    public void e(a aVar) {
        this.f19443c = aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridStrategyItem)) {
            return false;
        }
        GridStrategyItem gridStrategyItem = (GridStrategyItem) obj;
        if (!gridStrategyItem.a(this)) {
            return false;
        }
        GridStrategy d11 = d();
        GridStrategy d12 = gridStrategyItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = gridStrategyItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(GridStrategy gridStrategy) {
        this.f19442b = gridStrategy;
    }

    public String getViewHandlerName() {
        return GridStrategyViewHandler.class.getName();
    }

    public int hashCode() {
        GridStrategy d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        a c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "GridStrategyItem(gridStrategy=" + d() + ", callBack=" + c() + ")";
    }
}
