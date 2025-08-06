package pk;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.feature.ui.FutureTradeTogetherView;

public final /* synthetic */ class l0 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTradeTogetherView f53108b;

    public /* synthetic */ l0(FutureTradeTogetherView futureTradeTogetherView) {
        this.f53108b = futureTradeTogetherView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f53108b.Y1(view, motionEvent);
    }
}
