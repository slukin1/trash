package pk;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.feature.ui.FutureTradeView;

public final /* synthetic */ class w1 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTradeView f53156b;

    public /* synthetic */ w1(FutureTradeView futureTradeView) {
        this.f53156b = futureTradeView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f53156b.Q1(view, motionEvent);
    }
}
