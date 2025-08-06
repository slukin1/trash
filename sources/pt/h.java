package pt;

import android.content.Context;
import android.view.View;
import com.huobi.tradenew.handler.PlanOrderHandler;
import vo.b;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f53231b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f53232c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f53233d;

    public /* synthetic */ h(Context context, b bVar, boolean z11) {
        this.f53231b = context;
        this.f53232c = bVar;
        this.f53233d = z11;
    }

    public final void onClick(View view) {
        PlanOrderHandler.h(this.f53231b, this.f53232c, this.f53233d, view);
    }
}
