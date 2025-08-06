package com.huobi.otc.persenter;

import android.text.TextUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.OTCStatusResponse;
import com.hbg.lib.network.otc.core.bean.OtcChatUnread;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.websocket.protobuf.source.Message$Proto;
import i6.d;
import java.util.ArrayList;
import java.util.List;
import u6.g;
import up.x;

public abstract class OtcOrderUnReadNumP extends OtcWebSocketBaseP {

    /* renamed from: g  reason: collision with root package name */
    public x.f f79116g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f79117h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<String> f79118i;

    /* renamed from: j  reason: collision with root package name */
    public int f79119j;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            OtcOrderUnReadNumP.this.u();
        }
    }

    public class b implements x.f {
        public b() {
        }

        public void a(boolean z11, String str, Message$Proto message$Proto) {
            d.j("WebSocketPollingUtil", "PSocketMsgDispatcher ChatMessageCallBack  callBack");
            if (TextUtils.equals(OtcOrderUnReadNumP.this.r(), str)) {
                OtcOrderUnReadNumP otcOrderUnReadNumP = OtcOrderUnReadNumP.this;
                if (!otcOrderUnReadNumP.f79160e) {
                    if (z11) {
                        otcOrderUnReadNumP.f79119j++;
                    } else {
                        otcOrderUnReadNumP.f79119j--;
                    }
                    if (otcOrderUnReadNumP.s() != null) {
                        OtcOrderUnReadNumP otcOrderUnReadNumP2 = OtcOrderUnReadNumP.this;
                        otcOrderUnReadNumP2.v(otcOrderUnReadNumP2.f79119j);
                    }
                }
            }
        }
    }

    public class c extends BaseSubscriber<OTCStatusResponse<List<OtcChatUnread>>> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(OTCStatusResponse<List<OtcChatUnread>> oTCStatusResponse) {
            super.onNext(oTCStatusResponse);
            if (oTCStatusResponse != null && oTCStatusResponse.getData() != null && OtcOrderUnReadNumP.this.s() != null && OtcOrderUnReadNumP.this.s().isAlive()) {
                OtcOrderUnReadNumP.this.f79161f = true;
                List data = oTCStatusResponse.getData();
                for (int i11 = 0; i11 < data.size(); i11++) {
                    OtcChatUnread otcChatUnread = (OtcChatUnread) data.get(i11);
                    if (TextUtils.equals(String.valueOf(otcChatUnread.getOrderId()), OtcOrderUnReadNumP.this.r())) {
                        OtcOrderUnReadNumP.this.f79119j = otcChatUnread.getUnread();
                        OtcOrderUnReadNumP otcOrderUnReadNumP = OtcOrderUnReadNumP.this;
                        otcOrderUnReadNumP.v(otcOrderUnReadNumP.f79119j);
                        return;
                    }
                }
            }
        }

        public void onAfter() {
            super.onAfter();
            OtcOrderUnReadNumP otcOrderUnReadNumP = OtcOrderUnReadNumP.this;
            otcOrderUnReadNumP.f79160e = false;
            otcOrderUnReadNumP.g();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            OtcOrderUnReadNumP.this.f79161f = false;
        }
    }

    public Runnable b() {
        if (this.f79117h == null) {
            this.f79117h = new a();
        }
        return this.f79117h;
    }

    public x.f c() {
        if (this.f79116g == null) {
            this.f79116g = new b();
        }
        return this.f79116g;
    }

    public List<String> d() {
        if (this.f79118i == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.f79118i = arrayList;
            arrayList.add(r());
        }
        return this.f79118i;
    }

    public void l() {
        super.l();
        this.f79119j = 0;
        v(0);
    }

    public abstract String r();

    public abstract g s();

    public int t() {
        return this.f79119j;
    }

    public final void u() {
        if (!this.f79160e) {
            this.f79160e = true;
            s8.a.a().getChatUnread(r()).b().compose(RxJavaHelper.t(s())).subscribe(new c());
        }
    }

    public abstract void v(int i11);
}
