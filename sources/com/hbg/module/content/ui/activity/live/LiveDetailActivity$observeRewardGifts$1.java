package com.hbg.module.content.ui.activity.live;

import android.widget.ImageView;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.utils.event.bean.GiftBean;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import xe.h;

public final class LiveDetailActivity$observeRewardGifts$1 extends Lambda implements l<h, Unit> {
    public final /* synthetic */ LiveDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$observeRewardGifts$1(LiveDetailActivity liveDetailActivity) {
        super(1);
        this.this$0 = liveDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((h) obj);
        return Unit.f56620a;
    }

    public final void invoke(h hVar) {
        this.this$0.f18463k0 = hVar.a();
        this.this$0.f18461j0 = hVar.a().getCombo();
        if (hVar.a().getLabel() == 3) {
            this.this$0.Zj();
        } else {
            ImageView imageView = LiveDetailActivity.Ki(this.this$0).f19215g0;
            GiftBean zi2 = this.this$0.f18463k0;
            b.B(imageView, zi2 != null ? zi2.getUrlPng() : null);
            LiveDetailActivity liveDetailActivity = this.this$0;
            liveDetailActivity.Bk(LiveDetailActivity.Ki(liveDetailActivity).f19215g0, hVar.b());
        }
        LiveDetailActivity.xl(this.this$0, false, 1, (Object) null);
    }
}
