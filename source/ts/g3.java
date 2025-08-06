package ts;

import android.widget.CompoundButton;
import com.huobi.swap.ui.SwapTradeView;

public final /* synthetic */ class g3 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapTradeView f60359b;

    public /* synthetic */ g3(SwapTradeView swapTradeView) {
        this.f60359b = swapTradeView;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f60359b.Y1(compoundButton, z11);
    }
}
