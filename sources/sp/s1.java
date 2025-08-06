package sp;

import com.huobi.otc.bean.OtcOrderDetailInfo;
import com.huobi.otc.ui.OtcLiteChatActivity;
import rx.functions.Action1;

public final /* synthetic */ class s1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcLiteChatActivity f26086b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcOrderDetailInfo f26087c;

    public /* synthetic */ s1(OtcLiteChatActivity otcLiteChatActivity, OtcOrderDetailInfo otcOrderDetailInfo) {
        this.f26086b = otcLiteChatActivity;
        this.f26087c = otcOrderDetailInfo;
    }

    public final void call(Object obj) {
        this.f26086b.Ei(this.f26087c, (Void) obj);
    }
}
