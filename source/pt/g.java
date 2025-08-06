package pt;

import android.content.Context;
import android.view.View;
import com.huobi.tradenew.handler.PlanOrderHandler;
import vo.b;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f53228b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f53229c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f53230d;

    public /* synthetic */ g(Context context, b bVar, boolean z11) {
        this.f53228b = context;
        this.f53229c = bVar;
        this.f53230d = z11;
    }

    public final void onClick(View view) {
        PlanOrderHandler.g(this.f53228b, this.f53229c, this.f53230d, view);
    }
}
