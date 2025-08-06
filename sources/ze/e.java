package ze;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCurrentOrderInfo;
import com.hbg.module.linear.swap.viewhandler.LinearSwapCurrentOrderItemHandler;
import rx.functions.Action1;
import ye.a;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f62139b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LinearSwapCurrentOrderInfo f62140c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f62141d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f62142e;

    public /* synthetic */ e(a aVar, LinearSwapCurrentOrderInfo linearSwapCurrentOrderInfo, String str, String str2) {
        this.f62139b = aVar;
        this.f62140c = linearSwapCurrentOrderInfo;
        this.f62141d = str;
        this.f62142e = str2;
    }

    public final void call(Object obj) {
        LinearSwapCurrentOrderItemHandler.h(this.f62139b, this.f62140c, this.f62141d, this.f62142e, (Void) obj);
    }
}
