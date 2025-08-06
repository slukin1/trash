package qp;

import android.os.Handler;
import android.os.Message;
import com.huobi.otc.persenter.OtcWebSocketBaseP;

public final /* synthetic */ class v implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcWebSocketBaseP f60104b;

    public /* synthetic */ v(OtcWebSocketBaseP otcWebSocketBaseP) {
        this.f60104b = otcWebSocketBaseP;
    }

    public final boolean handleMessage(Message message) {
        return this.f60104b.f(message);
    }
}
