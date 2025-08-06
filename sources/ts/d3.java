package ts;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.swap.ui.SwapTradeView;

public final /* synthetic */ class d3 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapTradeView f60344b;

    public /* synthetic */ d3(SwapTradeView swapTradeView) {
        this.f60344b = swapTradeView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f60344b.Z1(view, motionEvent);
    }
}
