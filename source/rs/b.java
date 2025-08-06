package rs;

import com.huobi.swap.bean.SwapCurrentOrderItem;
import com.huobi.swap.handler.SwapCurrentOrderHandler;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapCurrentOrderItem f25800b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f25801c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f25802d;

    public /* synthetic */ b(SwapCurrentOrderItem swapCurrentOrderItem, String str, String str2) {
        this.f25800b = swapCurrentOrderItem;
        this.f25801c = str;
        this.f25802d = str2;
    }

    public final void call(Object obj) {
        SwapCurrentOrderHandler.f(this.f25800b, this.f25801c, this.f25802d, (Void) obj);
    }
}
