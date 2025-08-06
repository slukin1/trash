package vp;

import com.huobi.otc.bean.Ads;
import com.huobi.otc.widget.PaymentGroupView;
import rx.functions.Action1;

public final /* synthetic */ class p0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PaymentGroupView f61170b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ads.PaymentInfo f61171c;

    public /* synthetic */ p0(PaymentGroupView paymentGroupView, Ads.PaymentInfo paymentInfo) {
        this.f61170b = paymentGroupView;
        this.f61171c = paymentInfo;
    }

    public final void call(Object obj) {
        this.f61170b.c(this.f61171c, (Void) obj);
    }
}
