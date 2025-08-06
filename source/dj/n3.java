package dj;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.contract.ui.ContractTradeView;

public final /* synthetic */ class n3 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeView f53722b;

    public /* synthetic */ n3(ContractTradeView contractTradeView) {
        this.f53722b = contractTradeView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f53722b.U1(view, motionEvent);
    }
}
