package hp;

import android.view.View;
import com.huobi.otc.bean.OtcChatContent;
import com.huobi.otc.handler.OtcChatContentHandler;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcChatContentHandler f54959b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcChatContent f54960c;

    public /* synthetic */ k(OtcChatContentHandler otcChatContentHandler, OtcChatContent otcChatContent) {
        this.f54959b = otcChatContentHandler;
        this.f54960c = otcChatContent;
    }

    public final void onClick(View view) {
        this.f54959b.q(this.f54960c, view);
    }
}
