package sp;

import com.huobi.otc.bean.OtcOrderDetailInfo;
import com.huobi.otc.ui.OtcLiteChatActivity;
import rx.functions.Action1;

public final /* synthetic */ class p1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcLiteChatActivity f26069b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcOrderDetailInfo f26070c;

    public /* synthetic */ p1(OtcLiteChatActivity otcLiteChatActivity, OtcOrderDetailInfo otcOrderDetailInfo) {
        this.f26069b = otcLiteChatActivity;
        this.f26070c = otcOrderDetailInfo;
    }

    public final void call(Object obj) {
        this.f26069b.Di(this.f26070c, (Void) obj);
    }
}
