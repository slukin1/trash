package ym;

import android.content.Context;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTpSlRelationOrder;
import rx.functions.Action1;
import ym.f1;

public final /* synthetic */ class k1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f61852b;

    public /* synthetic */ k1(Context context) {
        this.f61852b = context;
    }

    public final void call(Object obj) {
        f1.l.f(this.f61852b, (LinearSwapTpSlRelationOrder) obj);
    }
}
