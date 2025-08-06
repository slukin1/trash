package vp;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.otc.widget.TabToggleView;

public final /* synthetic */ class s0 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TabToggleView f61177b;

    public /* synthetic */ s0(TabToggleView tabToggleView) {
        this.f61177b = tabToggleView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f61177b.f(view, motionEvent);
    }
}
