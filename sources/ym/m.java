package ym;

import android.content.Context;
import android.view.View;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.widgets.dialog.OrderConfirmBottomSheetDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class m implements OrderConfirmBottomSheetDialogFragment.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f61856a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f61857b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f61858c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FutureContractInfo f61859d;

    public /* synthetic */ m(z zVar, Context context, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        this.f61856a = zVar;
        this.f61857b = context;
        this.f61858c = contractOrderPlace;
        this.f61859d = futureContractInfo;
    }

    public final void a(boolean z11, View view) {
        this.f61856a.g0(this.f61857b, this.f61858c, this.f61859d, z11, view);
    }
}
