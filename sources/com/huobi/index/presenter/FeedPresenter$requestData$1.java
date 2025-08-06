package com.huobi.index.presenter;

import com.hbg.lib.network.hbg.core.bean.NewFeed;
import com.hbg.module.libkt.base.ext.b;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexRecommendLive;
import com.huobi.index.bean.IndexTopic;
import com.huobi.index.presenter.FeedPresenter;
import d10.p;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class FeedPresenter$requestData$1 extends Lambda implements p<Integer, Integer, Unit> {
    public final /* synthetic */ int $actionType;
    public final /* synthetic */ int $bizType;
    public final /* synthetic */ FeedPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedPresenter$requestData$1(FeedPresenter feedPresenter, int i11, int i12) {
        super(2);
        this.this$0 = feedPresenter;
        this.$actionType = i11;
        this.$bizType = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
        return Unit.f56620a;
    }

    public final void invoke(int i11, int i12) {
        List<NewFeed.CardIndexItem> z02;
        this.this$0.f0().f73308j = this.$actionType;
        this.this$0.f0().f73307i = i12;
        this.this$0.f0().f73309k = i11;
        if (this.this$0.getUI() != null) {
            ((FeedPresenter.a) this.this$0.getUI()).finishLoading();
        }
        this.this$0.c0().h(this.this$0.f0());
        this.this$0.f0().z(false);
        if (this.$bizType == 1 && this.$actionType == 0 && i11 == 0) {
            String str = "";
            HashMap hashMap = new HashMap();
            if (this.this$0.getUI() != null) {
                ((FeedPresenter.a) this.this$0.getUI()).H8();
            }
            HashMap hashMap2 = new HashMap();
            List<NewFeed.CardIndexItem> list = this.this$0.f0().f73305g.cardIndexList;
            if (!(list == null || (z02 = CollectionsKt___CollectionsKt.z0(list, new FeedPresenter$requestData$1$invoke$$inlined$compareBy$1())) == null)) {
                FeedPresenter feedPresenter = this.this$0;
                for (NewFeed.CardIndexItem cardIndexItem : z02) {
                    int i13 = cardIndexItem.type;
                    if (i13 == 1) {
                        HomeFeedInfoItem homeFeedInfoItem = new HomeFeedInfoItem();
                        IndexTopic indexTopic = new IndexTopic();
                        indexTopic.topics = feedPresenter.f0().f73305g.topic;
                        homeFeedInfoItem.f73166q = indexTopic;
                        homeFeedInfoItem.f73156g = 10;
                        hashMap2.put(Integer.valueOf(cardIndexItem.index), homeFeedInfoItem);
                    } else if (i13 == 2) {
                        NewFeed.CardIndexItem.Banner banner = cardIndexItem.banner;
                        if (banner != null) {
                            int i14 = banner.pageType;
                            str = (str + i14) + ',';
                            hashMap.put(Integer.valueOf(i14), Integer.valueOf(cardIndexItem.index));
                            hashMap2.put(Integer.valueOf(cardIndexItem.index), 0);
                        }
                    } else if (i13 == 3 && !b.w(feedPresenter.f0().f73305g.liveInfoList)) {
                        HomeFeedInfoItem homeFeedInfoItem2 = new HomeFeedInfoItem();
                        IndexRecommendLive indexRecommendLive = new IndexRecommendLive();
                        indexRecommendLive.liveInfoList = feedPresenter.f0().f73305g.liveInfoList;
                        homeFeedInfoItem2.f73167r = indexRecommendLive;
                        homeFeedInfoItem2.f73156g = 11;
                        hashMap2.put(Integer.valueOf(cardIndexItem.index), homeFeedInfoItem2);
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                this.this$0.h0(str.substring(0, str.length() - 1), hashMap, hashMap2);
                return;
            }
            FeedPresenter feedPresenter2 = this.this$0;
            for (Map.Entry entry : hashMap2.entrySet()) {
                int intValue = ((Number) entry.getKey()).intValue();
                Object value = entry.getValue();
                if (value instanceof HomeFeedInfoItem) {
                    feedPresenter2.f0().q().add(intValue, value);
                }
            }
        }
    }
}
