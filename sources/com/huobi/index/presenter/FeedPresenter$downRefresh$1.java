package com.huobi.index.presenter;

import com.hbg.lib.network.hbg.core.bean.HomeFeedAd;
import com.huobi.index.bean.HomeFeedAdData;
import d10.l;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import s9.a;

final class FeedPresenter$downRefresh$1 extends Lambda implements l<HomeFeedAdData, HomeFeedAdData> {
    public final /* synthetic */ FeedPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedPresenter$downRefresh$1(FeedPresenter feedPresenter) {
        super(1);
        this.this$0 = feedPresenter;
    }

    public final HomeFeedAdData invoke(final HomeFeedAdData homeFeedAdData) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        this.this$0.f73327d.j(new l<List<? extends a>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends a>) (List) obj);
                return Unit.f56620a;
            }

            public final void invoke(List<? extends a> list) {
                homeFeedAdData.f73150b = list;
                countDownLatch.countDown();
            }
        });
        this.this$0.f73327d.t(new l<HomeFeedAd, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeFeedAd) obj);
                return Unit.f56620a;
            }

            public final void invoke(HomeFeedAd homeFeedAd) {
                if (homeFeedAd != null) {
                    homeFeedAdData.f73149a = homeFeedAd;
                }
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        return homeFeedAdData;
    }
}
