package pk;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.feature.ui.FutureTradeView;

public final /* synthetic */ class u1 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTradeView f53148b;

    public /* synthetic */ u1(FutureTradeView futureTradeView) {
        this.f53148b = futureTradeView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f53148b.b2(view, motionEvent);
    }
}
