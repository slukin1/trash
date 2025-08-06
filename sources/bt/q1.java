package bt;

import android.content.Context;
import android.view.View;
import com.huobi.trade.handler.PlanOrderHandler;
import vo.b;

public final /* synthetic */ class q1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12963b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f12964c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f12965d;

    public /* synthetic */ q1(Context context, b bVar, boolean z11) {
        this.f12963b = context;
        this.f12964c = bVar;
        this.f12965d = z11;
    }

    public final void onClick(View view) {
        PlanOrderHandler.g(this.f12963b, this.f12964c, this.f12965d, view);
    }
}
