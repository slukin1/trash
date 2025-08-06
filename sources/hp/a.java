package hp;

import android.content.Context;
import com.huobi.otc.handler.AdsPublishViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54947b;

    public /* synthetic */ a(Context context) {
        this.f54947b = context;
    }

    public final void call(Object obj) {
        AdsPublishViewHandler.d(this.f54947b, (Void) obj);
    }
}
