package bj;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.widgets.dialog.OrderConfirmBottomSheetDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class b1 implements OrderConfirmBottomSheetDialogFragment.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d1 f12406a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12407b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f12408c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f12409d;

    public /* synthetic */ b1(d1 d1Var, Context context, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        this.f12406a = d1Var;
        this.f12407b = context;
        this.f12408c = contractOrderPlace;
        this.f12409d = contractCurrencyInfo;
    }

    public final void a(boolean z11, View view) {
        this.f12406a.E(this.f12407b, this.f12408c, this.f12409d, z11, view);
    }
}
