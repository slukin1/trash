package com.huobi.finance.bean;

import com.hbg.lib.network.hbg.grid.bean.GridAccountRunningStrategyInfo;
import com.huobi.finance.viewhandler.GridAssetDetailListItemHandler;

public class GridAssetDetailListItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public String f45361b;

    /* renamed from: c  reason: collision with root package name */
    public GridAccountRunningStrategyInfo f45362c;

    /* renamed from: d  reason: collision with root package name */
    public a f45363d;

    public interface a {
        void a(GridAssetDetailListItem gridAssetDetailListItem);
    }

    public boolean a(Object obj) {
        return obj instanceof GridAssetDetailListItem;
    }

    public a c() {
        return this.f45363d;
    }

    public GridAccountRunningStrategyInfo d() {
        return this.f45362c;
    }

    public String e() {
        return this.f45361b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridAssetDetailListItem)) {
            return false;
        }
        GridAssetDetailListItem gridAssetDetailListItem = (GridAssetDetailListItem) obj;
        if (!gridAssetDetailListItem.a(this)) {
            return false;
        }
        String e11 = e();
        String e12 = gridAssetDetailListItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        GridAccountRunningStrategyInfo d11 = d();
        GridAccountRunningStrategyInfo d12 = gridAssetDetailListItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = gridAssetDetailListItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(a aVar) {
        this.f45363d = aVar;
    }

    public void g(GridAccountRunningStrategyInfo gridAccountRunningStrategyInfo) {
        this.f45362c = gridAccountRunningStrategyInfo;
    }

    public String getViewHandlerName() {
        return GridAssetDetailListItemHandler.class.getName();
    }

    public void h(String str) {
        this.f45361b = str;
    }

    public int hashCode() {
        String e11 = e();
        int i11 = 43;
        int hashCode = e11 == null ? 43 : e11.hashCode();
        GridAccountRunningStrategyInfo d11 = d();
        int hashCode2 = ((hashCode + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        a c11 = c();
        int i12 = hashCode2 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "GridAssetDetailListItem(symbol=" + e() + ", info=" + d() + ", callback=" + c() + ")";
    }
}
