package bj;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.widgets.dialog.OrderConfirmBottomSheetDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class s0 implements OrderConfirmBottomSheetDialogFragment.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d1 f12491a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12492b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f12493c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f12494d;

    public /* synthetic */ s0(d1 d1Var, Context context, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        this.f12491a = d1Var;
        this.f12492b = context;
        this.f12493c = contractOrderPlace;
        this.f12494d = contractCurrencyInfo;
    }

    public final void a(boolean z11, View view) {
        this.f12491a.I(this.f12492b, this.f12493c, this.f12494d, z11, view);
    }
}
