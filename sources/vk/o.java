package vk;

import c6.b;
import com.hbg.lib.network.hbg.grid.bean.GridAccountConvertInfo;
import com.huobi.finance.viewhandler.GridAssetListItemHandler;
import s9.a;

public class o implements a {

    /* renamed from: b  reason: collision with root package name */
    public GridAccountConvertInfo f48000b;

    /* renamed from: c  reason: collision with root package name */
    public b<o> f48001c;

    public o(GridAccountConvertInfo gridAccountConvertInfo, b<o> bVar) {
        this.f48000b = gridAccountConvertInfo;
        this.f48001c = bVar;
    }

    public boolean a(Object obj) {
        return obj instanceof o;
    }

    public GridAccountConvertInfo c() {
        return this.f48000b;
    }

    public b<o> d() {
        return this.f48001c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (!oVar.a(this)) {
            return false;
        }
        GridAccountConvertInfo c11 = c();
        GridAccountConvertInfo c12 = oVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        b<o> d11 = d();
        b<o> d12 = oVar.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public String getViewHandlerName() {
        return GridAssetListItemHandler.class.getName();
    }

    public int hashCode() {
        GridAccountConvertInfo c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        b<o> d11 = d();
        int i12 = (hashCode + 59) * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "GridAssetListItem(info=" + c() + ", onClickListener=" + d() + ")";
    }
}
