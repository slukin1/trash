package com.hbg.module.content.ui.activity.live;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.utils.event.bean.GiftBean;
import d10.l;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.d0;

public final class LiveDetailActivity$observeIntegralGiftInfo$1 extends Lambda implements l<GiftBean, Unit> {
    public final /* synthetic */ LiveDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$observeIntegralGiftInfo$1(LiveDetailActivity liveDetailActivity) {
        super(1);
        this.this$0 = liveDetailActivity;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(LiveDetailActivity liveDetailActivity) {
        LiveDetailActivity.Ki(liveDetailActivity).f19201b1.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        LiveDetailActivity.Ki(liveDetailActivity).f19211e2.setMaxWidth(((((LiveDetailActivity.Ki(liveDetailActivity).f19219h1.getWidth() - LiveDetailActivity.Ki(liveDetailActivity).f19219h1.getPaddingStart()) - LiveDetailActivity.Ki(liveDetailActivity).f19219h1.getPaddingEnd()) - LiveDetailActivity.Ki(liveDetailActivity).f19252u0.getWidth()) - LiveDetailActivity.Ki(liveDetailActivity).f19214f2.getWidth()) - LiveDetailActivity.Ki(liveDetailActivity).f19201b1.getMeasuredWidth());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GiftBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(GiftBean giftBean) {
        String str;
        int i11 = 8;
        LiveDetailActivity.Ki(this.this$0).Z0.setVisibility(8);
        LinearLayout linearLayout = LiveDetailActivity.Ki(this.this$0).f19201b1;
        if (giftBean.getLabel() == 1) {
            i11 = 0;
        }
        linearLayout.setVisibility(i11);
        b.B(LiveDetailActivity.Ki(this.this$0).f19252u0, giftBean.getUrlPng());
        LiveDetailActivity.Ki(this.this$0).f19214f2.setText(giftBean.getGiftName() + com.sumsub.sns.internal.fingerprint.infoproviders.l.f34627b);
        TextView textView = LiveDetailActivity.Ki(this.this$0).f19211e2;
        if (giftBean.getLabel() == 1) {
            d0 d0Var = d0.f56774a;
            str = String.format(this.this$0.getString(R$string.n_live_gift_integral_unlock), Arrays.copyOf(new Object[]{String.valueOf(giftBean.getUnlockIntegral())}, 1));
        } else {
            str = giftBean.getGiftIntroduction();
        }
        textView.setText(str);
        LiveDetailActivity.Ki(this.this$0).f19219h1.setVisibility(0);
        if (giftBean.getLabel() == 1) {
            LiveDetailActivity.Ki(this.this$0).f19201b1.post(new w1(this.this$0));
        } else {
            LiveDetailActivity.Ki(this.this$0).f19211e2.setMaxWidth(Integer.MAX_VALUE);
        }
    }
}
