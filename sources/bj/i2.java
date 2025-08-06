package bj;

import android.content.Context;
import bj.h2;
import com.huobi.contract.entity.ContractTpSlRelationOrder;
import rx.functions.Action1;

public final /* synthetic */ class i2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12437b;

    public /* synthetic */ i2(Context context) {
        this.f12437b = context;
    }

    public final void call(Object obj) {
        h2.g.f(this.f12437b, (ContractTpSlRelationOrder) obj);
    }
}
