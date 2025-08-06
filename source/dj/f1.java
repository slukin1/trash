package dj;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.contract.ui.ContractTradeBaseFragment;

public final /* synthetic */ class f1 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeBaseFragment f53673b;

    public /* synthetic */ f1(ContractTradeBaseFragment contractTradeBaseFragment) {
        this.f53673b = contractTradeBaseFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f53673b.Ci(view, motionEvent);
    }
}
