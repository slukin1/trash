package sp;

import com.huobi.otc.bean.OtcOrderDetailInfo;
import com.huobi.otc.ui.OtcLiteChatActivity;
import rx.functions.Action1;

public final /* synthetic */ class t1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcLiteChatActivity f26091b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcOrderDetailInfo f26092c;

    public /* synthetic */ t1(OtcLiteChatActivity otcLiteChatActivity, OtcOrderDetailInfo otcOrderDetailInfo) {
        this.f26091b = otcLiteChatActivity;
        this.f26092c = otcOrderDetailInfo;
    }

    public final void call(Object obj) {
        this.f26091b.Fi(this.f26092c, (Void) obj);
    }
}
