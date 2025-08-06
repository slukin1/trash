package com.huobi.index.repository;

import com.hbg.lib.network.hbg.core.bean.HomeFeedAd;
import d10.l;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class FeedRepository$getHomeAds$1 extends Lambda implements l<HomeFeedAd, Unit> {
    public final /* synthetic */ HashMap<Integer, Integer> $adMap;
    public final /* synthetic */ HashMap<Integer, Object> $insertDataMap;
    public final /* synthetic */ FeedRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedRepository$getHomeAds$1(FeedRepository feedRepository, HashMap<Integer, Integer> hashMap, HashMap<Integer, Object> hashMap2) {
        super(1);
        this.this$0 = feedRepository;
        this.$adMap = hashMap;
        this.$insertDataMap = hashMap2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HomeFeedAd) obj);
        return Unit.f56620a;
    }

    public final void invoke(HomeFeedAd homeFeedAd) {
        this.this$0.w().lock();
        this.this$0.f73479a.f73313o = homeFeedAd;
        try {
            FeedRepository feedRepository = this.this$0;
            feedRepository.m(this.$adMap, this.$insertDataMap, homeFeedAd, (ArrayList) feedRepository.f73479a.q());
        } catch (Exception unused) {
        } catch (Throwable th2) {
            this.this$0.w().unlock();
            throw th2;
        }
        this.this$0.w().unlock();
    }
}
