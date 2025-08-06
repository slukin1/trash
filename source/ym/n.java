package ym;

import android.content.Context;
import android.view.View;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.widgets.dialog.OrderConfirmBottomSheetDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class n implements OrderConfirmBottomSheetDialogFragment.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f61864a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f61865b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f61866c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FutureContractInfo f61867d;

    public /* synthetic */ n(z zVar, Context context, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        this.f61864a = zVar;
        this.f61865b = context;
        this.f61866c = contractOrderPlace;
        this.f61867d = futureContractInfo;
    }

    public final void a(boolean z11, View view) {
        this.f61864a.e0(this.f61865b, this.f61866c, this.f61867d, z11, view);
    }
}
