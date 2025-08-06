package hp;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.otc.bean.OtcChatContent;
import com.huobi.otc.handler.OtcChatContentHandler;

public final /* synthetic */ class m implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OtcChatContent f54963a;

    public /* synthetic */ m(OtcChatContent otcChatContent) {
        this.f54963a = otcChatContent;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        OtcChatContentHandler.p(this.f54963a, hBDialogFragment);
    }
}
