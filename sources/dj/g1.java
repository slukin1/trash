package dj;

import android.widget.CompoundButton;
import com.huobi.contract.ui.ContractTradeBaseFragment;

public final /* synthetic */ class g1 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeBaseFragment f53679b;

    public /* synthetic */ g1(ContractTradeBaseFragment contractTradeBaseFragment) {
        this.f53679b = contractTradeBaseFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f53679b.Bi(compoundButton, z11);
    }
}
