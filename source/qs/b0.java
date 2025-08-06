package qs;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.dialog.OrderConfirmBottomSheetDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class b0 implements OrderConfirmBottomSheetDialogFragment.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f70378a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f70379b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f70380c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfo f70381d;

    public /* synthetic */ b0(d0 d0Var, Context context, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        this.f70378a = d0Var;
        this.f70379b = context;
        this.f70380c = contractOrderPlace;
        this.f70381d = swapCurrencyInfo;
    }

    public final void a(boolean z11, View view) {
        this.f70378a.J(this.f70379b, this.f70380c, this.f70381d, z11, view);
    }
}
