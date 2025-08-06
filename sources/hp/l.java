package hp;

import android.view.View;
import com.huobi.otc.bean.OtcChatContent;
import com.huobi.otc.handler.OtcChatContentHandler;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcChatContentHandler f54961b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcChatContent f54962c;

    public /* synthetic */ l(OtcChatContentHandler otcChatContentHandler, OtcChatContent otcChatContent) {
        this.f54961b = otcChatContentHandler;
        this.f54962c = otcChatContent;
    }

    public final void onClick(View view) {
        this.f54961b.n(this.f54962c, view);
    }
}
