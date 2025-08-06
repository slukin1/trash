package ts;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.swap.ui.SwapTradeTogetherView;

public final /* synthetic */ class t1 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapTradeTogetherView f60432b;

    public /* synthetic */ t1(SwapTradeTogetherView swapTradeTogetherView) {
        this.f60432b = swapTradeTogetherView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f60432b.V1(view, motionEvent);
    }
}
