package sp;

import com.huobi.otc.bean.OtcOrderDetailInfo;
import com.huobi.otc.ui.OtcLiteChatActivity;
import rx.functions.Action1;

public final /* synthetic */ class r1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcLiteChatActivity f26081b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcOrderDetailInfo f26082c;

    public /* synthetic */ r1(OtcLiteChatActivity otcLiteChatActivity, OtcOrderDetailInfo otcOrderDetailInfo) {
        this.f26081b = otcLiteChatActivity;
        this.f26082c = otcOrderDetailInfo;
    }

    public final void call(Object obj) {
        this.f26081b.Gi(this.f26082c, (Void) obj);
    }
}
