package ts;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.swap.ui.SwapTradeView;

public final /* synthetic */ class e3 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapTradeView f60349b;

    public /* synthetic */ e3(SwapTradeView swapTradeView) {
        this.f60349b = swapTradeView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f60349b.R1(view, motionEvent);
    }
}
