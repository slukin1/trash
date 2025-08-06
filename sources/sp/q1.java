package sp;

import com.huobi.otc.bean.OtcOrderDetailInfo;
import com.huobi.otc.ui.OtcLiteChatActivity;
import rx.functions.Action1;

public final /* synthetic */ class q1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcLiteChatActivity f26076b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcOrderDetailInfo f26077c;

    public /* synthetic */ q1(OtcLiteChatActivity otcLiteChatActivity, OtcOrderDetailInfo otcOrderDetailInfo) {
        this.f26076b = otcLiteChatActivity;
        this.f26077c = otcOrderDetailInfo;
    }

    public final void call(Object obj) {
        this.f26076b.Hi(this.f26077c, (Void) obj);
    }
}
