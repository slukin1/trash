package qs;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.dialog.OrderConfirmBottomSheetDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class q implements OrderConfirmBottomSheetDialogFragment.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f70432a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f70433b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f70434c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfo f70435d;

    public /* synthetic */ q(d0 d0Var, Context context, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        this.f70432a = d0Var;
        this.f70433b = context;
        this.f70434c = contractOrderPlace;
        this.f70435d = swapCurrencyInfo;
    }

    public final void a(boolean z11, View view) {
        this.f70432a.H(this.f70433b, this.f70434c, this.f70435d, z11, view);
    }
}
