package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.hbg.core.bean.HomeFeedAd;
import com.hbg.lib.network.hbg.core.bean.NewFeed;
import com.huobi.index.bean.FeedRequestItems;
import com.huobi.index.bean.HomeFeedInfoItem;
import i6.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class NewFeedModule extends HomePageModule<List<s9.a>> {

    /* renamed from: c  reason: collision with root package name */
    public final Lock f73301c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public final Lock f73302d = new ReentrantLock();

    /* renamed from: e  reason: collision with root package name */
    public List<s9.a> f73303e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public boolean f73304f = false;

    /* renamed from: g  reason: collision with root package name */
    public NewFeed f73305g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f73306h = false;

    /* renamed from: i  reason: collision with root package name */
    public int f73307i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f73308j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f73309k = 0;

    /* renamed from: l  reason: collision with root package name */
    public List<s9.a> f73310l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public List<FeedRequestItems> f73311m;

    /* renamed from: n  reason: collision with root package name */
    public final int f73312n = 30;

    /* renamed from: o  reason: collision with root package name */
    public HomeFeedAd f73313o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f73314p = false;

    public class a extends TypeToken<List<HomeFeedInfoItem>> {
        public a() {
        }
    }

    public class b implements Action1<String> {
        public b() {
        }

        /* renamed from: a */
        public void call(String str) {
            d.j("yangzhinan", "currentThread=" + Thread.currentThread().getName() + "---s2222=" + str);
            ArrayList arrayList = new ArrayList();
            List k11 = NewFeedModule.this.f73303e;
            int min = Math.min(30, k11.size());
            for (int i11 = 0; i11 < min; i11++) {
                if (((HomeFeedInfoItem) k11.get(i11)).n() != 6) {
                    arrayList.add((s9.a) k11.get(i11));
                }
            }
            NewFeedModule.this.w(arrayList);
        }
    }

    public String e() {
        return "SP_TAG_INFORMATION_220618";
    }

    public void h() {
    }

    /* renamed from: l */
    public String b(List<s9.a> list) {
        return new Gson().toJson((Object) list);
    }

    /* renamed from: m */
    public List<s9.a> c(String str) {
        return (List) new Gson().fromJson(str, new a().getType());
    }

    public void n(HomeFeedAd.PageBannerListDTO pageBannerListDTO) {
        if (pageBannerListDTO != null) {
            Iterator<HomeFeedAd.PageBannerListDTO.BannerAdvListDTO> it2 = pageBannerListDTO.getBannerAdvList().iterator();
            while (it2.hasNext()) {
                HomeFeedAd.PageBannerListDTO.BannerAdvListDTO next = it2.next();
                if (next == null || next.getImageUrl() == null || next.getImageUrl().equals("") || next.getJumpTo() == null || next.getJumpTo().equals("")) {
                    it2.remove();
                }
            }
        }
    }

    public synchronized void o(List<s9.a> list, int i11, int i12) {
    }

    public List<s9.a> p() {
        this.f73301c.lock();
        try {
            return (List) super.d();
        } finally {
            this.f73301c.unlock();
        }
    }

    public List<s9.a> q() {
        this.f73302d.lock();
        try {
            return this.f73303e;
        } finally {
            this.f73302d.unlock();
        }
    }

    public boolean r() {
        return this.f73304f;
    }

    public boolean s(int i11) {
        List<s9.a> list = this.f73303e;
        if (list != null && list.size() >= 30) {
            int size = this.f73303e.size();
            if (i11 == 0) {
                this.f73303e.subList(30, size).clear();
                return true;
            }
        }
        return false;
    }

    /* renamed from: t */
    public List<s9.a> i(List<s9.a> list) {
        return list;
    }

    public void u(List<s9.a> list, int i11) {
        if (this.f73291b == null) {
            this.f73291b = new ArrayList();
        }
        if (i11 == 2) {
            ((List) this.f73291b).addAll(list);
        } else {
            ((List) this.f73291b).addAll(0, list);
        }
    }

    public void v() {
        if (this.f73303e != null) {
            Observable.just("1").subscribeOn(Schedulers.io()).subscribe(new b());
        }
    }

    public void w(List<s9.a> list) {
        this.f73301c.lock();
        super.j(list);
        this.f73301c.unlock();
    }

    public void x() {
        ArrayList arrayList = new ArrayList();
        List<s9.a> p11 = p();
        if (p11 != null) {
            for (s9.a next : p11) {
                FeedRequestItems feedRequestItems = new FeedRequestItems();
                if (next instanceof HomeFeedInfoItem) {
                    HomeFeedInfoItem homeFeedInfoItem = (HomeFeedInfoItem) next;
                    if (homeFeedInfoItem.n() == 1) {
                        feedRequestItems.d(Long.valueOf(homeFeedInfoItem.p().getId()));
                        feedRequestItems.e(Integer.valueOf(homeFeedInfoItem.n()));
                    } else if (homeFeedInfoItem.n() == 2) {
                        feedRequestItems.d(Long.valueOf(homeFeedInfoItem.g().getId()));
                        feedRequestItems.e(Integer.valueOf(homeFeedInfoItem.n()));
                    } else if (homeFeedInfoItem.n() != 100) {
                        if (homeFeedInfoItem.n() == 4) {
                            feedRequestItems.d(Long.valueOf((long) homeFeedInfoItem.i().getId()));
                            feedRequestItems.e(Integer.valueOf(homeFeedInfoItem.n()));
                        } else if (homeFeedInfoItem.n() == 6) {
                            feedRequestItems.d(Long.valueOf((long) homeFeedInfoItem.k().getId().intValue()));
                            feedRequestItems.e(Integer.valueOf(homeFeedInfoItem.n()));
                        }
                    }
                }
                arrayList.add(feedRequestItems);
            }
        }
        this.f73311m = arrayList;
    }

    public void y(List<s9.a> list) {
        this.f73302d.lock();
        try {
            this.f73303e.clear();
            this.f73303e.addAll(list);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            this.f73302d.unlock();
            throw th2;
        }
        this.f73302d.unlock();
    }

    public void z(boolean z11) {
        this.f73304f = z11;
    }
}
