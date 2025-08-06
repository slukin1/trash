package com.huobi.index.bean;

import com.hbg.lib.network.hbg.core.bean.DeepNews;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.huobi.homemarket.model.MarketRemindFlashItem;
import com.huobi.index.viewhandler.IndexDeepHandler;
import com.huobi.index.viewhandler.IndexInformationHandler;
import com.huobi.index.viewhandler.IndexMarketRemindHandler;

public class IndexInformationItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public NewFlashInformation f73184b;

    /* renamed from: c  reason: collision with root package name */
    public String f73185c;

    /* renamed from: d  reason: collision with root package name */
    public String f73186d;

    /* renamed from: e  reason: collision with root package name */
    public b f73187e;

    /* renamed from: f  reason: collision with root package name */
    public a f73188f;

    /* renamed from: g  reason: collision with root package name */
    public int f73189g;

    /* renamed from: h  reason: collision with root package name */
    public DeepNews f73190h;

    /* renamed from: i  reason: collision with root package name */
    public MarketRemindFlashItem f73191i;

    /* renamed from: j  reason: collision with root package name */
    public IndexAd f73192j;

    public interface a {
    }

    public interface b {
        void a(int i11, int i12, IndexInformationItem indexInformationItem);

        void b(int i11, IndexInformationItem indexInformationItem);
    }

    public boolean a(Object obj) {
        return obj instanceof IndexInformationItem;
    }

    public a c() {
        return this.f73188f;
    }

    public String d() {
        return this.f73185c;
    }

    public b e() {
        return this.f73187e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexInformationItem)) {
            return false;
        }
        IndexInformationItem indexInformationItem = (IndexInformationItem) obj;
        if (!indexInformationItem.a(this)) {
            return false;
        }
        NewFlashInformation k11 = k();
        NewFlashInformation k12 = indexInformationItem.k();
        if (k11 != null ? !k11.equals(k12) : k12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = indexInformationItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = indexInformationItem.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        b e11 = e();
        b e12 = indexInformationItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = indexInformationItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        if (i() != indexInformationItem.i()) {
            return false;
        }
        DeepNews g11 = g();
        DeepNews g12 = indexInformationItem.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        MarketRemindFlashItem j11 = j();
        MarketRemindFlashItem j12 = indexInformationItem.j();
        if (j11 != null ? !j11.equals(j12) : j12 != null) {
            return false;
        }
        IndexAd h11 = h();
        IndexAd h12 = indexInformationItem.h();
        return h11 != null ? h11.equals(h12) : h12 == null;
    }

    public String f() {
        return this.f73186d;
    }

    public DeepNews g() {
        return this.f73190h;
    }

    public String getViewHandlerName() {
        int i11 = this.f73189g;
        if (i11 == 2) {
            return IndexDeepHandler.class.getName();
        }
        if (i11 == 3) {
            return IndexMarketRemindHandler.class.getName();
        }
        return IndexInformationHandler.class.getName();
    }

    public IndexAd h() {
        return this.f73192j;
    }

    public int hashCode() {
        NewFlashInformation k11 = k();
        int i11 = 43;
        int hashCode = k11 == null ? 43 : k11.hashCode();
        String d11 = d();
        int hashCode2 = ((hashCode + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        String f11 = f();
        int hashCode3 = (hashCode2 * 59) + (f11 == null ? 43 : f11.hashCode());
        b e11 = e();
        int hashCode4 = (hashCode3 * 59) + (e11 == null ? 43 : e11.hashCode());
        a c11 = c();
        int hashCode5 = (((hashCode4 * 59) + (c11 == null ? 43 : c11.hashCode())) * 59) + i();
        DeepNews g11 = g();
        int hashCode6 = (hashCode5 * 59) + (g11 == null ? 43 : g11.hashCode());
        MarketRemindFlashItem j11 = j();
        int hashCode7 = (hashCode6 * 59) + (j11 == null ? 43 : j11.hashCode());
        IndexAd h11 = h();
        int i12 = hashCode7 * 59;
        if (h11 != null) {
            i11 = h11.hashCode();
        }
        return i12 + i11;
    }

    public int i() {
        return this.f73189g;
    }

    public MarketRemindFlashItem j() {
        return this.f73191i;
    }

    public NewFlashInformation k() {
        return this.f73184b;
    }

    public void l(a aVar) {
        this.f73188f = aVar;
    }

    public String toString() {
        return "IndexInformationItem(newFlashInformation=" + k() + ", baseInfo=" + d() + ", date=" + f() + ", callBack=" + e() + ", actionAnimalCallBack=" + c() + ", itemType=" + i() + ", deepNews=" + g() + ", marketRemindFlashItem=" + j() + ", indexAd=" + h() + ")";
    }
}
