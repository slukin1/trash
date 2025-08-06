package dj;

import android.widget.CompoundButton;
import com.huobi.contract.ui.ContractTradeTogetherView;

public final /* synthetic */ class i2 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeTogetherView f53692b;

    public /* synthetic */ i2(ContractTradeTogetherView contractTradeTogetherView) {
        this.f53692b = contractTradeTogetherView;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f53692b.M1(compoundButton, z11);
    }
}
