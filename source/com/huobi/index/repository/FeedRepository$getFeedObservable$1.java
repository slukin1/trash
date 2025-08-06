package com.huobi.index.repository;

import com.hbg.lib.network.hbg.core.bean.NewFeed;
import com.huobi.utils.HomeHelper;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import s9.a;

public final class FeedRepository$getFeedObservable$1 extends Lambda implements l<NewFeed, Unit> {
    public final /* synthetic */ int $actionType;
    public final /* synthetic */ int $bizType;
    public final /* synthetic */ FeedRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedRepository$getFeedObservable$1(FeedRepository feedRepository, int i11, int i12) {
        super(1);
        this.this$0 = feedRepository;
        this.$bizType = i11;
        this.$actionType = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NewFeed) obj);
        return Unit.f56620a;
    }

    public final void invoke(NewFeed newFeed) {
        this.this$0.w().lock();
        List<a> k11 = HomeHelper.k(newFeed, this.$bizType);
        if (this.$actionType == 0) {
            this.this$0.f73479a.q().clear();
            List<a> p11 = this.this$0.f73479a.p();
            if (p11 != null) {
                p11.clear();
            }
        }
        try {
            if (this.$bizType != 3) {
                this.this$0.f73479a.o(k11, this.$bizType, this.$actionType);
            }
            if (this.$actionType == 2) {
                this.this$0.f73479a.q().addAll(k11);
            } else {
                this.this$0.f73479a.q().addAll(0, k11);
            }
            this.this$0.f73479a.u(k11, this.$actionType);
            this.this$0.f73479a.f73305g = newFeed;
            if (this.$bizType == 1) {
                this.this$0.f73479a.f73314p = this.this$0.f73479a.s(this.$actionType);
            }
            newFeed.actionType = this.$actionType;
            if (this.$bizType == 3) {
                this.this$0.f73479a.x();
            }
        } catch (Exception unused) {
        } catch (Throwable th2) {
            this.this$0.w().unlock();
            throw th2;
        }
        this.this$0.w().unlock();
    }
}
