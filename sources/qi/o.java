package qi;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.c2c.lend.view.C2CLendTradeLayout;

public final /* synthetic */ class o implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2CLendTradeLayout f53394b;

    public /* synthetic */ o(C2CLendTradeLayout c2CLendTradeLayout) {
        this.f53394b = c2CLendTradeLayout;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f53394b.B(view, motionEvent);
    }
}
