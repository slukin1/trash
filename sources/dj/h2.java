package dj;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.contract.ui.ContractTradeTogetherView;

public final /* synthetic */ class h2 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeTogetherView f53686b;

    public /* synthetic */ h2(ContractTradeTogetherView contractTradeTogetherView) {
        this.f53686b = contractTradeTogetherView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f53686b.E1(view, motionEvent);
    }
}
