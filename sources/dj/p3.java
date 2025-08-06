package dj;

import android.widget.CompoundButton;
import com.huobi.contract.ui.ContractTradeView;

public final /* synthetic */ class p3 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeView f53732b;

    public /* synthetic */ p3(ContractTradeView contractTradeView) {
        this.f53732b = contractTradeView;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f53732b.c2(compoundButton, z11);
    }
}
