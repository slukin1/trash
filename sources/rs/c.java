package rs;

import android.content.Context;
import com.huobi.swap.handler.SwapCurrentStopOrderHandler;
import ps.a;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f25803b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f25804c;

    public /* synthetic */ c(a aVar, Context context) {
        this.f25803b = aVar;
        this.f25804c = context;
    }

    public final void call(Object obj) {
        SwapCurrentStopOrderHandler.d(this.f25803b, this.f25804c, (Void) obj);
    }
}
