package id;

import com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend;
import com.hbg.module.huobi.im.gift.ui.LiveGiftFloatButton;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveGiftFloatButton f55058b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CusMsgGiftSend f55059c;

    public /* synthetic */ p(LiveGiftFloatButton liveGiftFloatButton, CusMsgGiftSend cusMsgGiftSend) {
        this.f55058b = liveGiftFloatButton;
        this.f55059c = cusMsgGiftSend;
    }

    public final void run() {
        LiveGiftFloatButton.l(this.f55058b, this.f55059c);
    }
}
