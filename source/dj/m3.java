package dj;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.contract.ui.ContractTradeView;

public final /* synthetic */ class m3 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeView f53717b;

    public /* synthetic */ m3(ContractTradeView contractTradeView) {
        this.f53717b = contractTradeView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f53717b.d2(view, motionEvent);
    }
}
