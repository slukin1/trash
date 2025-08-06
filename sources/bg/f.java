package bg;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.module.swap.bean.SwapPositionItem;
import com.hbg.module.swap.viewhandler.SwapPositionViewHandler;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapPositionViewHandler f12368b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwapPosition f12369c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f12370d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SwapPositionItem f12371e;

    public /* synthetic */ f(SwapPositionViewHandler swapPositionViewHandler, SwapPosition swapPosition, Context context, SwapPositionItem swapPositionItem) {
        this.f12368b = swapPositionViewHandler;
        this.f12369c = swapPosition;
        this.f12370d = context;
        this.f12371e = swapPositionItem;
    }

    public final void onClick(View view) {
        this.f12368b.s(this.f12369c, this.f12370d, this.f12371e, view);
    }
}
