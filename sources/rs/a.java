package rs;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.swap.core.bean.SwapCurrentOrderInfo;
import com.huobi.swap.bean.SwapCurrentOrderItem;
import com.huobi.swap.handler.SwapCurrentOrderHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapCurrentOrderItem f25797b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwapCurrentOrderInfo f25798c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f25799d;

    public /* synthetic */ a(SwapCurrentOrderItem swapCurrentOrderItem, SwapCurrentOrderInfo swapCurrentOrderInfo, Context context) {
        this.f25797b = swapCurrentOrderItem;
        this.f25798c = swapCurrentOrderInfo;
        this.f25799d = context;
    }

    public final void onClick(View view) {
        SwapCurrentOrderHandler.e(this.f25797b, this.f25798c, this.f25799d, view);
    }
}
