package ze;

import android.view.View;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCurrentOrderInfo;
import com.hbg.module.linear.swap.viewhandler.LinearSwapCurrentOrderItemHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapCurrentOrderInfo f62134b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ye.a f62135c;

    public /* synthetic */ a(LinearSwapCurrentOrderInfo linearSwapCurrentOrderInfo, ye.a aVar) {
        this.f62134b = linearSwapCurrentOrderInfo;
        this.f62135c = aVar;
    }

    public final void onClick(View view) {
        LinearSwapCurrentOrderItemHandler.k(this.f62134b, this.f62135c, view);
    }
}
