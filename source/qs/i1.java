package qs;

import android.content.Context;
import com.hbg.lib.network.swap.core.bean.SwapTpSlRelationOrder;
import qs.h1;
import rx.functions.Action1;

public final /* synthetic */ class i1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f70405b;

    public /* synthetic */ i1(Context context) {
        this.f70405b = context;
    }

    public final void call(Object obj) {
        h1.g.f(this.f70405b, (SwapTpSlRelationOrder) obj);
    }
}
