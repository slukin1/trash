package com.huobi.otc.persenter;

import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.OTCStatusResponse;
import com.hbg.lib.network.otc.core.bean.OtcChatUnread;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;

public abstract class OtcTradeChatNumP extends OtcOrderUnReadNumP {

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            OtcTradeChatNumP.this.x();
        }
    }

    public class b extends BaseSubscriber<OTCStatusResponse<OtcChatUnread>> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(OTCStatusResponse<OtcChatUnread> oTCStatusResponse) {
            super.onNext(oTCStatusResponse);
            if (oTCStatusResponse != null && oTCStatusResponse.getData() != null && OtcTradeChatNumP.this.s() != null && OtcTradeChatNumP.this.s().isAlive()) {
                OtcTradeChatNumP.this.f79161f = true;
                OtcTradeChatNumP.this.f79119j = oTCStatusResponse.getData().getUnread();
                OtcTradeChatNumP otcTradeChatNumP = OtcTradeChatNumP.this;
                otcTradeChatNumP.v(otcTradeChatNumP.f79119j);
            }
        }

        public void onAfter() {
            super.onAfter();
            OtcTradeChatNumP otcTradeChatNumP = OtcTradeChatNumP.this;
            otcTradeChatNumP.f79160e = false;
            otcTradeChatNumP.g();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            OtcTradeChatNumP.this.f79161f = false;
        }
    }

    public Runnable b() {
        if (this.f79117h == null) {
            this.f79117h = new a();
        }
        return this.f79117h;
    }

    public void k() {
        super.k();
        m(false);
    }

    public final void x() {
        if (!this.f79160e) {
            this.f79160e = true;
            s8.a.a().getChatUnReadAll().b().compose(RxJavaHelper.t(s())).subscribe(new b());
        }
    }
}
