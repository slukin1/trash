package com.huobi.index.repository;

import com.hbg.lib.network.hbg.core.bean.HomeFeedAd;
import com.hbg.lib.network.hbg.core.bean.NewFeed;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.huobi.index.bean.FeedRequestItems;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexAd;
import com.huobi.index.bean.IndexInformationRequestData;
import com.huobi.index.helper.data.NewFeedModule;
import com.huobi.utils.HomeHelper;
import d10.l;
import d10.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class FeedRepository {

    /* renamed from: c  reason: collision with root package name */
    public static final a f73478c = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final NewFeedModule f73479a;

    /* renamed from: b  reason: collision with root package name */
    public final ReentrantLock f73480b = new ReentrantLock();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b extends BaseSubscriber<List<? extends s9.a>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l<List<? extends s9.a>, Unit> f73481b;

        public b(l<? super List<? extends s9.a>, Unit> lVar) {
            this.f73481b = lVar;
        }

        public void onNext(List<? extends s9.a> list) {
            this.f73481b.invoke(list);
        }
    }

    public static final class c extends BaseSubscriber<HomeFeedAd> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ p<Integer, Integer, Unit> f73482b;

        public c(p<? super Integer, ? super Integer, Unit> pVar) {
            this.f73482b = pVar;
        }

        /* renamed from: a */
        public void onNext(HomeFeedAd homeFeedAd) {
            if (homeFeedAd.getPageBannerList() != null) {
                this.f73482b.invoke(0, Integer.valueOf(homeFeedAd.lastRefreshIndex));
            } else {
                this.f73482b.invoke(1, 0);
            }
        }
    }

    public static final class d extends BaseSubscriber<HomeFeedAd> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l<HomeFeedAd, Unit> f73483b;

        public d(l<? super HomeFeedAd, Unit> lVar) {
            this.f73483b = lVar;
        }

        /* renamed from: a */
        public void onNext(HomeFeedAd homeFeedAd) {
            this.f73483b.invoke(homeFeedAd);
        }
    }

    public static final class e extends BaseSubscriber<NewFeed> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ p<Integer, Integer, Unit> f73484b;

        public e(p<? super Integer, ? super Integer, Unit> pVar) {
            this.f73484b = pVar;
        }

        /* renamed from: a */
        public void onNext(NewFeed newFeed) {
            super.onNext(newFeed);
            p<Integer, Integer, Unit> pVar = this.f73484b;
            int i11 = 0;
            Integer valueOf = Integer.valueOf((newFeed.items == null && newFeed.topic == null) ? 1 : 0);
            List<NewFeed.FeedItem> list = newFeed.items;
            if (list != null) {
                i11 = list.size();
            }
            pVar.invoke(valueOf, Integer.valueOf(i11));
        }
    }

    public FeedRepository(NewFeedModule newFeedModule) {
        this.f73479a = newFeedModule;
    }

    public static final List k(l lVar, Object obj) {
        return (List) lVar.invoke(obj);
    }

    public static final List l(l lVar, Object obj) {
        return (List) lVar.invoke(obj);
    }

    public static final void o(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    public static final NewFeed p(l lVar, Object obj) {
        return (NewFeed) lVar.invoke(obj);
    }

    public static final void r(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    public static final HomeFeedAd s(l lVar, Object obj) {
        return (HomeFeedAd) lVar.invoke(obj);
    }

    public static final HomeFeedAd u(l lVar, Object obj) {
        return (HomeFeedAd) lVar.invoke(obj);
    }

    public static final void v(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    public final void j(l<? super List<? extends s9.a>, Unit> lVar) {
        this.f73479a.g();
        v7.b.a().getFeedList(IndexInformationRequestData.b().a(1, 0, 0, (List<FeedRequestItems>) null, (this.f73479a.q() == null || this.f73479a.q().size() <= 0) ? 0 : this.f73479a.q().size())).b().map(new g(new FeedRepository$downGetRequestData$1(this))).onErrorReturn(new e(FeedRepository$downGetRequestData$2.INSTANCE)).subscribeOn(Schedulers.io()).subscribe(new b(lVar));
    }

    public final void m(HashMap<Integer, Integer> hashMap, HashMap<Integer, Object> hashMap2, HomeFeedAd homeFeedAd, ArrayList<s9.a> arrayList) {
        List<HomeFeedAd.PageBannerListDTO> pageBannerList = homeFeedAd.getPageBannerList();
        int i11 = 0;
        if (pageBannerList != null) {
            int i12 = 0;
            for (T next : pageBannerList) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                HomeFeedAd.PageBannerListDTO pageBannerListDTO = (HomeFeedAd.PageBannerListDTO) next;
                this.f73479a.n(pageBannerListDTO);
                HomeFeedInfoItem homeFeedInfoItem = new HomeFeedInfoItem();
                if (pageBannerListDTO.getBannerAdvList() != null && pageBannerListDTO.getBannerAdvList().size() > 0) {
                    HomeFeedAd.PageBannerListDTO.BannerAdvListDTO x11 = x(pageBannerListDTO.getPageType().intValue(), pageBannerListDTO.getBannerAdvList());
                    Integer advId = x11.getAdvId();
                    SPUtil.l(String.valueOf(pageBannerListDTO.getPageType()), advId == null ? 0 : advId.intValue());
                    IndexAd indexAd = new IndexAd();
                    indexAd.advId = x11.getAdvId();
                    indexAd.imageUrl = x11.getImageUrl();
                    indexAd.nightImageUrl = x11.getNightImageUrl();
                    indexAd.jumpTo = x11.getJumpTo();
                    indexAd.pageType = pageBannerListDTO.getPageType();
                    homeFeedInfoItem.f73162m = indexAd;
                    homeFeedInfoItem.f73156g = 999;
                    Integer num = hashMap.get(pageBannerListDTO.getPageType());
                    if (num != null) {
                        hashMap2.put(num, homeFeedInfoItem);
                    }
                }
                i12 = i13;
            }
        }
        for (Map.Entry next2 : hashMap2.entrySet()) {
            int intValue = ((Number) next2.getKey()).intValue();
            Object value = next2.getValue();
            if ((value instanceof HomeFeedInfoItem) && intValue < this.f73479a.q().size()) {
                if (intValue > i11) {
                    i11 = intValue;
                }
                this.f73479a.q().add(intValue, value);
            }
        }
        homeFeedAd.lastRefreshIndex = i11;
    }

    public final Observable<NewFeed> n(int i11, int i12) {
        List<FeedRequestItems> list;
        List<FeedRequestItems> list2;
        if (!this.f73479a.g()) {
            return Observable.just(null);
        }
        long j11 = 0;
        int i13 = 0;
        if (this.f73479a.q() != null && this.f73479a.q().size() > 0) {
            if (i12 != 0) {
                i13 = this.f73479a.q().size();
            }
            s9.a aVar = this.f73479a.q().get(this.f73479a.q().size() - 1);
            if (i12 == 2) {
                j11 = HomeHelper.e(aVar);
            }
            if (i11 == 3 && i12 == 2 && (list2 = this.f73479a.f73311m) != null) {
                list = list2;
                return v7.b.a().getFeedList(IndexInformationRequestData.b().a(i11, i12, j11, list, i13)).b().doOnNext(new c(new FeedRepository$getFeedObservable$1(this, i11, i12))).onErrorReturn(new d(FeedRepository$getFeedObservable$2.INSTANCE)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        }
        list = null;
        return v7.b.a().getFeedList(IndexInformationRequestData.b().a(i11, i12, j11, list, i13)).b().doOnNext(new c(new FeedRepository$getFeedObservable$1(this, i11, i12))).onErrorReturn(new d(FeedRepository$getFeedObservable$2.INSTANCE)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public final void q(String str, HashMap<Integer, Integer> hashMap, HashMap<Integer, Object> hashMap2, p<? super Integer, ? super Integer, Unit> pVar) {
        v7.b.a().getHomeFeedAd(str).b().doOnNext(new a(new FeedRepository$getHomeAds$1(this, hashMap, hashMap2))).onErrorReturn(new h(FeedRepository$getHomeAds$2.INSTANCE)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(pVar));
    }

    public final void t(l<? super HomeFeedAd, Unit> lVar) {
        v7.b.a().getHomeFeedAd("24,25,26").b().doOnNext(new b(FeedRepository$getHomeAdsNew$1.INSTANCE)).onErrorReturn(new f(FeedRepository$getHomeAdsNew$2.INSTANCE)).subscribeOn(Schedulers.io()).subscribe(new d(lVar));
    }

    public final ReentrantLock w() {
        return this.f73480b;
    }

    public final HomeFeedAd.PageBannerListDTO.BannerAdvListDTO x(int i11, List<? extends HomeFeedAd.PageBannerListDTO.BannerAdvListDTO> list) {
        return (HomeFeedAd.PageBannerListDTO.BannerAdvListDTO) list.get(y(SPUtil.a(String.valueOf(i11), 0), list.size(), list));
    }

    public final int y(int i11, int i12, List<? extends HomeFeedAd.PageBannerListDTO.BannerAdvListDTO> list) {
        int i13 = 0;
        int i14 = 0;
        for (T next : list) {
            int i15 = i14 + 1;
            if (i14 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            Integer advId = ((HomeFeedAd.PageBannerListDTO.BannerAdvListDTO) next).getAdvId();
            if (advId != null && advId.intValue() == i11) {
                i13 = i14;
            }
            i14 = i15;
        }
        if (i13 < i12 - 1) {
            return i13 + 1;
        }
        return 0;
    }

    public final void z(int i11, int i12, p<? super Integer, ? super Integer, Unit> pVar) {
        if (!this.f73479a.r()) {
            this.f73479a.z(true);
            Observable<NewFeed> n11 = n(i11, i12);
            if (n11 != null) {
                n11.subscribe((Subscriber<? super NewFeed>) new e(pVar));
            }
        }
    }
}
