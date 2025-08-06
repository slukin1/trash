package com.huobi.index.presenter;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.huobi.index.helper.data.NewFeedModule;
import com.huobi.index.repository.FeedRepository;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import u6.g;
import we.b;

public final class FeedPresenter extends BaseFragmentPresenter<a> {

    /* renamed from: c  reason: collision with root package name */
    public final NewFeedModule f73326c;

    /* renamed from: d  reason: collision with root package name */
    public FeedRepository f73327d;

    /* renamed from: e  reason: collision with root package name */
    public final b.a<NewFeedModule> f73328e = new b.a<>("getData");

    /* renamed from: f  reason: collision with root package name */
    public final b.a<NewFeedModule> f73329f = new b.a<>("getAdData");

    public interface a extends g {
        void F9(ArrayList<LiveBannerData> arrayList);

        void H8();

        void finishLoading();
    }

    public FeedPresenter() {
        NewFeedModule newFeedModule = new NewFeedModule();
        this.f73326c = newFeedModule;
        this.f73327d = new FeedRepository(newFeedModule);
    }

    public final b.a<NewFeedModule> c0() {
        return this.f73328e;
    }

    public final b.a<NewFeedModule> d0() {
        return this.f73329f;
    }

    public final NewFeedModule f0() {
        return this.f73326c;
    }

    public final void g0(LifecycleCoroutineScope lifecycleCoroutineScope, int i11, int i12) {
        if (i11 == 1 && this.f73326c.p() == null) {
            n1 unused = i.d(lifecycleCoroutineScope, v0.c(), (CoroutineStart) null, new FeedPresenter$initData$1(this, i12, i11, (c<? super FeedPresenter$initData$1>) null), 2, (Object) null);
            return;
        }
        i0(i12, i11);
    }

    public final void h0(String str, HashMap<Integer, Integer> hashMap, HashMap<Integer, Object> hashMap2) {
        this.f73327d.q(str, hashMap, hashMap2, new FeedPresenter$requestAdData$1(this));
    }

    public final void i0(int i11, int i12) {
        this.f73327d.z(i12, i11, new FeedPresenter$requestData$1(this, i11, i12));
    }

    public final void j0() {
        RequestExtKt.d(v7.b.a().getLiveBanner(6, NightHelper.e().g() ? 1 : 0), new FeedPresenter$requestRankData$1(this), FeedPresenter$requestRankData$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public final void k0() {
        this.f73326c.v();
    }
}
