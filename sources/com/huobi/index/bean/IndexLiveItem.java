package com.huobi.index.bean;

import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.huobi.index.viewhandler.IndexLiveHandler;
import com.huobi.index.viewhandler.IndexLiveTwoHandler;
import ef.b;
import s9.a;

public class IndexLiveItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public LiveDetailBean f73202b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f73203c;

    /* renamed from: d  reason: collision with root package name */
    public String f73204d;

    public boolean a(Object obj) {
        return obj instanceof IndexLiveItem;
    }

    public String c() {
        return this.f73204d;
    }

    public LiveDetailBean d() {
        return this.f73202b;
    }

    public b.a e() {
        return this.f73203c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexLiveItem)) {
            return false;
        }
        IndexLiveItem indexLiveItem = (IndexLiveItem) obj;
        if (!indexLiveItem.a(this)) {
            return false;
        }
        LiveDetailBean d11 = d();
        LiveDetailBean d12 = indexLiveItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        b.a e11 = e();
        b.a e12 = indexLiveItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = indexLiveItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(LiveDetailBean liveDetailBean) {
        this.f73202b = liveDetailBean;
    }

    public void g(b.a aVar) {
        this.f73203c = aVar;
    }

    public String getViewHandlerName() {
        LiveDetailBean liveDetailBean = this.f73202b;
        if (liveDetailBean == null || 3 != liveDetailBean.getViewType()) {
            return IndexLiveTwoHandler.class.getName();
        }
        return IndexLiveHandler.class.getName();
    }

    public int hashCode() {
        LiveDetailBean d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        b.a e11 = e();
        int hashCode2 = ((hashCode + 59) * 59) + (e11 == null ? 43 : e11.hashCode());
        String c11 = c();
        int i12 = hashCode2 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "IndexLiveItem(livePlayingData=" + d() + ", onItemClickListener=" + e() + ", date=" + c() + ")";
    }
}
