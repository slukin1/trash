package hp;

import android.view.View;
import com.huobi.otc.handler.OtcChatContentHandler;
import rx.functions.Action1;

public final /* synthetic */ class n implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f54964b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54965c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f54966d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f54967e;

    public /* synthetic */ n(View view, String str, String str2, int i11) {
        this.f54964b = view;
        this.f54965c = str;
        this.f54966d = str2;
        this.f54967e = i11;
    }

    public final void call(Object obj) {
        OtcChatContentHandler.s(this.f54964b, this.f54965c, this.f54966d, this.f54967e, (Void) obj);
    }
}
