package ze;

import android.content.Context;
import com.hbg.module.linear.swap.viewhandler.LinearSwapCurrentTriggerOrderItemHandler;
import rx.functions.Action1;
import ye.d;

public final /* synthetic */ class i implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f62147b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f62148c;

    public /* synthetic */ i(d dVar, Context context) {
        this.f62147b = dVar;
        this.f62148c = context;
    }

    public final void call(Object obj) {
        LinearSwapCurrentTriggerOrderItemHandler.f(this.f62147b, this.f62148c, (Void) obj);
    }
}
