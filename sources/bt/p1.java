package bt;

import android.content.Context;
import android.view.View;
import com.huobi.trade.handler.PlanOrderHandler;
import vo.b;

public final /* synthetic */ class p1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12957b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f12958c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f12959d;

    public /* synthetic */ p1(Context context, b bVar, boolean z11) {
        this.f12957b = context;
        this.f12958c = bVar;
        this.f12959d = z11;
    }

    public final void onClick(View view) {
        PlanOrderHandler.h(this.f12957b, this.f12958c, this.f12959d, view);
    }
}
