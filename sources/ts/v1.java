package ts;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.swap.ui.SwapTradeTogetherView;

public final /* synthetic */ class v1 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapTradeTogetherView f60443b;

    public /* synthetic */ v1(SwapTradeTogetherView swapTradeTogetherView) {
        this.f60443b = swapTradeTogetherView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f60443b.I1(view, motionEvent);
    }
}
