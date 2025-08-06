package qi;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.c2c.lend.view.C2CLendTradeLayout;

public final /* synthetic */ class p implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2CLendTradeLayout f53395b;

    public /* synthetic */ p(C2CLendTradeLayout c2CLendTradeLayout) {
        this.f53395b = c2CLendTradeLayout;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f53395b.C(view, motionEvent);
    }
}
