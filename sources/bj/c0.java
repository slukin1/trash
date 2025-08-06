package bj;

import android.content.Context;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.helper.ContractOrderHelper;
import rx.functions.Func1;

public final /* synthetic */ class c0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12412b;

    public /* synthetic */ c0(Context context) {
        this.f12412b = context;
    }

    public final Object call(Object obj) {
        return ContractOrderHelper.j(this.f12412b, (ContractPosition) obj);
    }
}
