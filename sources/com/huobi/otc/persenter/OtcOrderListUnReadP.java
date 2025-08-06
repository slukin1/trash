package com.huobi.otc.persenter;

import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.OTCStatusResponse;
import com.hbg.lib.network.otc.core.bean.OtcChatUnread;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.websocket.protobuf.source.Message$Proto;
import i6.d;
import java.util.List;
import u6.g;
import up.x;

public abstract class OtcOrderListUnReadP extends OtcWebSocketBaseP {

    /* renamed from: g  reason: collision with root package name */
    public x.f f79111g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f79112h;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            OtcOrderListUnReadP.this.s();
        }
    }

    public class b implements x.f {
        public b() {
        }

        public void a(boolean z11, String str, Message$Proto message$Proto) {
            d.j("WebSocketPollingUtil", "PSocketMsgDispatcher OtcOrderListUnReadPresenter  callBack");
        }
    }

    public class c extends EasySubscriber<OTCStatusResponse<List<OtcChatUnread>>> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(OTCStatusResponse<List<OtcChatUnread>> oTCStatusResponse) {
            super.onNext(oTCStatusResponse);
            if (oTCStatusResponse != null && oTCStatusResponse.getData() != null) {
                OtcOrderListUnReadP otcOrderListUnReadP = OtcOrderListUnReadP.this;
                otcOrderListUnReadP.f79161f = true;
                otcOrderListUnReadP.u(oTCStatusResponse.getData());
            }
        }

        public void onAfter() {
            super.onAfter();
            OtcOrderListUnReadP otcOrderListUnReadP = OtcOrderListUnReadP.this;
            otcOrderListUnReadP.f79160e = false;
            otcOrderListUnReadP.g();
        }

        public void onError2(Throwable th2) {
            OtcOrderListUnReadP.this.f79161f = false;
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            OtcOrderListUnReadP.this.f79161f = false;
        }
    }

    public Runnable b() {
        if (this.f79112h == null) {
            this.f79112h = new a();
        }
        return this.f79112h;
    }

    public x.f c() {
        if (this.f79111g == null) {
            this.f79111g = new b();
        }
        return this.f79111g;
    }

    public abstract String r();

    public final void s() {
        if (!this.f79160e) {
            this.f79160e = true;
            s8.a.a().getChatUnread(r()).b().compose(RxJavaHelper.t(t())).subscribe(new c());
        }
    }

    public abstract g t();

    public abstract void u(List<OtcChatUnread> list);
}
