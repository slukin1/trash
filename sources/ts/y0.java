package ts;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.swap.ui.SwapTradeBaseFragment;

public final /* synthetic */ class y0 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapTradeBaseFragment f60458b;

    public /* synthetic */ y0(SwapTradeBaseFragment swapTradeBaseFragment) {
        this.f60458b = swapTradeBaseFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f60458b.Ai(view, motionEvent);
    }
}
