package dj;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.contract.ui.ContractTradeTogetherView;

public final /* synthetic */ class f2 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeTogetherView f53674b;

    public /* synthetic */ f2(ContractTradeTogetherView contractTradeTogetherView) {
        this.f53674b = contractTradeTogetherView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f53674b.O1(view, motionEvent);
    }
}
