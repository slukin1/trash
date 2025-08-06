package dj;

import android.widget.CompoundButton;
import com.huobi.contract.ui.ContractTradeBaseFragment;

public final /* synthetic */ class h1 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeBaseFragment f53685b;

    public /* synthetic */ h1(ContractTradeBaseFragment contractTradeBaseFragment) {
        this.f53685b = contractTradeBaseFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f53685b.Ai(compoundButton, z11);
    }
}
