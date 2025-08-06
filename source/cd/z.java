package cd;

import android.view.View;
import com.hbg.module.exchange.grid.ui.GridTradeInputView;

public final /* synthetic */ class z implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridTradeInputView f13069b;

    public /* synthetic */ z(GridTradeInputView gridTradeInputView) {
        this.f13069b = gridTradeInputView;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f13069b.h(view, z11);
    }
}
