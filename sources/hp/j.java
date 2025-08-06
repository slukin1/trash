package hp;

import android.view.View;
import com.huobi.otc.bean.OtcChatContent;
import com.huobi.otc.handler.OtcChatContentHandler;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcChatContentHandler f54957b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcChatContent f54958c;

    public /* synthetic */ j(OtcChatContentHandler otcChatContentHandler, OtcChatContent otcChatContent) {
        this.f54957b = otcChatContentHandler;
        this.f54958c = otcChatContent;
    }

    public final void onClick(View view) {
        this.f54957b.o(this.f54958c, view);
    }
}
