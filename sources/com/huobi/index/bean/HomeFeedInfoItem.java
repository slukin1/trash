package com.huobi.index.bean;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.huobi.homemarket.model.MarketRemindFlashItem;
import com.huobi.index.viewhandler.IndexContractHandler;
import com.huobi.index.viewhandler.IndexSpecialHandler;
import com.huobi.index.viewhandler.NewDeepHandler;
import com.huobi.index.viewhandler.NewsAdHandler;
import com.huobi.index.viewhandler.NewsCommunityHandler;
import com.huobi.index.viewhandler.NewsFlashHandler;
import com.huobi.index.viewhandler.NewsLiveHandler;
import com.huobi.index.viewhandler.NewsRecommendLiveHandler;
import com.huobi.index.viewhandler.NewsTopicHandler;
import com.huobi.index.viewhandler.RecommendTagHandler;

public class HomeFeedInfoItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public NewFlashInformation f73151b;

    /* renamed from: c  reason: collision with root package name */
    public String f73152c;

    /* renamed from: d  reason: collision with root package name */
    public String f73153d;

    /* renamed from: e  reason: collision with root package name */
    public b f73154e;

    /* renamed from: f  reason: collision with root package name */
    public a f73155f;

    /* renamed from: g  reason: collision with root package name */
    public int f73156g;

    /* renamed from: h  reason: collision with root package name */
    public IndexDeep f73157h;

    /* renamed from: i  reason: collision with root package name */
    public MarketRemindFlashItem f73158i;

    /* renamed from: j  reason: collision with root package name */
    public IndexContract f73159j;

    /* renamed from: k  reason: collision with root package name */
    public CommunityFeedInfo.ListBean f73160k;

    /* renamed from: l  reason: collision with root package name */
    public IndexLive f73161l;

    /* renamed from: m  reason: collision with root package name */
    public IndexAd f73162m;

    /* renamed from: n  reason: collision with root package name */
    public IndexSpecial f73163n;

    /* renamed from: o  reason: collision with root package name */
    public IndexContract f73164o;

    /* renamed from: p  reason: collision with root package name */
    public int f73165p = 1;

    /* renamed from: q  reason: collision with root package name */
    public IndexTopic f73166q;

    /* renamed from: r  reason: collision with root package name */
    public IndexRecommendLive f73167r;

    public interface a {
    }

    public interface b {
    }

    public void A(MarketRemindFlashItem marketRemindFlashItem) {
        this.f73158i = marketRemindFlashItem;
    }

    public void B(NewFlashInformation newFlashInformation) {
        this.f73151b = newFlashInformation;
    }

    public void C(IndexContract indexContract) {
        this.f73164o = indexContract;
    }

    public void D(int i11) {
        this.f73165p = i11;
    }

    public boolean a(Object obj) {
        return obj instanceof HomeFeedInfoItem;
    }

    public a c() {
        return this.f73155f;
    }

    public String d() {
        return this.f73152c;
    }

    public b e() {
        return this.f73154e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HomeFeedInfoItem)) {
            return false;
        }
        HomeFeedInfoItem homeFeedInfoItem = (HomeFeedInfoItem) obj;
        if (!homeFeedInfoItem.a(this)) {
            return false;
        }
        NewFlashInformation p11 = p();
        NewFlashInformation p12 = homeFeedInfoItem.p();
        if (p11 != null ? !p11.equals(p12) : p12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = homeFeedInfoItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = homeFeedInfoItem.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        b e11 = e();
        b e12 = homeFeedInfoItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = homeFeedInfoItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        if (n() != homeFeedInfoItem.n()) {
            return false;
        }
        IndexDeep g11 = g();
        IndexDeep g12 = homeFeedInfoItem.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        MarketRemindFlashItem o11 = o();
        MarketRemindFlashItem o12 = homeFeedInfoItem.o();
        if (o11 != null ? !o11.equals(o12) : o12 != null) {
            return false;
        }
        IndexContract j11 = j();
        IndexContract j12 = homeFeedInfoItem.j();
        if (j11 != null ? !j11.equals(j12) : j12 != null) {
            return false;
        }
        CommunityFeedInfo.ListBean i11 = i();
        CommunityFeedInfo.ListBean i12 = homeFeedInfoItem.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        IndexLive k11 = k();
        IndexLive k12 = homeFeedInfoItem.k();
        if (k11 != null ? !k11.equals(k12) : k12 != null) {
            return false;
        }
        IndexAd h11 = h();
        IndexAd h12 = homeFeedInfoItem.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        IndexSpecial m11 = m();
        IndexSpecial m12 = homeFeedInfoItem.m();
        if (m11 != null ? !m11.equals(m12) : m12 != null) {
            return false;
        }
        IndexContract q11 = q();
        IndexContract q12 = homeFeedInfoItem.q();
        if (q11 != null ? !q11.equals(q12) : q12 != null) {
            return false;
        }
        if (r() != homeFeedInfoItem.r()) {
            return false;
        }
        IndexTopic s11 = s();
        IndexTopic s12 = homeFeedInfoItem.s();
        if (s11 != null ? !s11.equals(s12) : s12 != null) {
            return false;
        }
        IndexRecommendLive l11 = l();
        IndexRecommendLive l12 = homeFeedInfoItem.l();
        return l11 != null ? l11.equals(l12) : l12 == null;
    }

    public String f() {
        return this.f73153d;
    }

    public IndexDeep g() {
        return this.f73157h;
    }

    public String getViewHandlerName() {
        Class<NewsFlashHandler> cls = NewsFlashHandler.class;
        int i11 = this.f73156g;
        if (i11 == 2) {
            return NewDeepHandler.class.getName();
        }
        if (i11 == 100) {
            return IndexContractHandler.class.getName();
        }
        if (i11 == 4) {
            return NewsCommunityHandler.class.getName();
        }
        if (i11 == 6) {
            return NewsLiveHandler.class.getName();
        }
        if (i11 == 11) {
            return NewsRecommendLiveHandler.class.getName();
        }
        if (i11 == 999) {
            return NewsAdHandler.class.getName();
        }
        if (i11 == 10) {
            return NewsTopicHandler.class.getName();
        }
        if (i11 == 1) {
            return cls.getName();
        }
        if (i11 == 14) {
            return IndexSpecialHandler.class.getName();
        }
        if (i11 == 500) {
            return RecommendTagHandler.class.getName();
        }
        return cls.getName();
    }

    public IndexAd h() {
        return this.f73162m;
    }

    public int hashCode() {
        NewFlashInformation p11 = p();
        int i11 = 43;
        int hashCode = p11 == null ? 43 : p11.hashCode();
        String d11 = d();
        int hashCode2 = ((hashCode + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        String f11 = f();
        int hashCode3 = (hashCode2 * 59) + (f11 == null ? 43 : f11.hashCode());
        b e11 = e();
        int hashCode4 = (hashCode3 * 59) + (e11 == null ? 43 : e11.hashCode());
        a c11 = c();
        int hashCode5 = (((hashCode4 * 59) + (c11 == null ? 43 : c11.hashCode())) * 59) + n();
        IndexDeep g11 = g();
        int hashCode6 = (hashCode5 * 59) + (g11 == null ? 43 : g11.hashCode());
        MarketRemindFlashItem o11 = o();
        int hashCode7 = (hashCode6 * 59) + (o11 == null ? 43 : o11.hashCode());
        IndexContract j11 = j();
        int hashCode8 = (hashCode7 * 59) + (j11 == null ? 43 : j11.hashCode());
        CommunityFeedInfo.ListBean i12 = i();
        int hashCode9 = (hashCode8 * 59) + (i12 == null ? 43 : i12.hashCode());
        IndexLive k11 = k();
        int hashCode10 = (hashCode9 * 59) + (k11 == null ? 43 : k11.hashCode());
        IndexAd h11 = h();
        int hashCode11 = (hashCode10 * 59) + (h11 == null ? 43 : h11.hashCode());
        IndexSpecial m11 = m();
        int hashCode12 = (hashCode11 * 59) + (m11 == null ? 43 : m11.hashCode());
        IndexContract q11 = q();
        int hashCode13 = (((hashCode12 * 59) + (q11 == null ? 43 : q11.hashCode())) * 59) + r();
        IndexTopic s11 = s();
        int hashCode14 = (hashCode13 * 59) + (s11 == null ? 43 : s11.hashCode());
        IndexRecommendLive l11 = l();
        int i13 = hashCode14 * 59;
        if (l11 != null) {
            i11 = l11.hashCode();
        }
        return i13 + i11;
    }

    public CommunityFeedInfo.ListBean i() {
        return this.f73160k;
    }

    public IndexContract j() {
        return this.f73159j;
    }

    public IndexLive k() {
        return this.f73161l;
    }

    public IndexRecommendLive l() {
        return this.f73167r;
    }

    public IndexSpecial m() {
        return this.f73163n;
    }

    public int n() {
        return this.f73156g;
    }

    public MarketRemindFlashItem o() {
        return this.f73158i;
    }

    public NewFlashInformation p() {
        return this.f73151b;
    }

    public IndexContract q() {
        return this.f73164o;
    }

    public int r() {
        return this.f73165p;
    }

    public IndexTopic s() {
        return this.f73166q;
    }

    public void t(String str) {
        this.f73152c = str;
    }

    public String toString() {
        return "HomeFeedInfoItem(newFlashInformation=" + p() + ", baseInfo=" + d() + ", date=" + f() + ", callBack=" + e() + ", actionAnimalCallBack=" + c() + ", itemType=" + n() + ", deepNews=" + g() + ", marketRemindFlashItem=" + o() + ", indexContract=" + j() + ", indexCommunity=" + i() + ", indexLive=" + k() + ", indexAd=" + h() + ", indexSpecial=" + m() + ", recommendedLabel=" + q() + ", tabType=" + r() + ", topic=" + s() + ", indexRecommendLive=" + l() + ")";
    }

    public void u(IndexDeep indexDeep) {
        this.f73157h = indexDeep;
    }

    public void v(CommunityFeedInfo.ListBean listBean) {
        this.f73160k = listBean;
    }

    public void w(IndexContract indexContract) {
        this.f73159j = indexContract;
    }

    public void x(IndexLive indexLive) {
        this.f73161l = indexLive;
    }

    public void y(IndexSpecial indexSpecial) {
        this.f73163n = indexSpecial;
    }

    public void z(int i11) {
        this.f73156g = i11;
    }
}
