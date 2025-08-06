package bj;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.widgets.dialog.OrderConfirmBottomSheetDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class r0 implements OrderConfirmBottomSheetDialogFragment.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d1 f12484a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12485b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f12486c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f12487d;

    public /* synthetic */ r0(d1 d1Var, Context context, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        this.f12484a = d1Var;
        this.f12485b = context;
        this.f12486c = contractOrderPlace;
        this.f12487d = contractCurrencyInfo;
    }

    public final void a(boolean z11, View view) {
        this.f12484a.C(this.f12485b, this.f12486c, this.f12487d, z11, view);
    }
}
