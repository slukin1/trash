package hp;

import android.widget.TextView;
import com.huobi.otc.bean.OtcChatContent;
import com.huobi.otc.handler.OtcChatContentHandler;
import rx.functions.Action1;

public final /* synthetic */ class o implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcChatContent f54968b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f54969c;

    public /* synthetic */ o(OtcChatContent otcChatContent, TextView textView) {
        this.f54968b = otcChatContent;
        this.f54969c = textView;
    }

    public final void call(Object obj) {
        OtcChatContentHandler.r(this.f54968b, this.f54969c, (Void) obj);
    }
}
