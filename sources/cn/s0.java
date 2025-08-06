package cn;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;

public final /* synthetic */ class s0 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapTradeBaseFragment f13191b;

    public /* synthetic */ s0(LinearSwapTradeBaseFragment linearSwapTradeBaseFragment) {
        this.f13191b = linearSwapTradeBaseFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f13191b.ej(view, motionEvent);
    }
}
