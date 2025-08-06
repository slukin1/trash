package ym;

import android.content.Context;
import android.view.View;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.widgets.dialog.OrderConfirmBottomSheetDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class x implements OrderConfirmBottomSheetDialogFragment.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f61899a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f61900b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f61901c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FutureContractInfo f61902d;

    public /* synthetic */ x(z zVar, Context context, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        this.f61899a = zVar;
        this.f61900b = context;
        this.f61901c = contractOrderPlace;
        this.f61902d = futureContractInfo;
    }

    public final void a(boolean z11, View view) {
        this.f61899a.k0(this.f61900b, this.f61901c, this.f61902d, z11, view);
    }
}
