package qs;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.dialog.OrderConfirmBottomSheetDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class r implements OrderConfirmBottomSheetDialogFragment.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f70440a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f70441b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f70442c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfo f70443d;

    public /* synthetic */ r(d0 d0Var, Context context, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        this.f70440a = d0Var;
        this.f70441b = context;
        this.f70442c = contractOrderPlace;
        this.f70443d = swapCurrencyInfo;
    }

    public final void a(boolean z11, View view) {
        this.f70440a.N(this.f70441b, this.f70442c, this.f70443d, z11, view);
    }
}
