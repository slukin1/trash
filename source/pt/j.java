package pt;

import android.content.Context;
import android.view.View;
import com.huobi.tradenew.handler.SpotOrderEmptyViewHandler;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ rt.j f53235b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f53236c;

    public /* synthetic */ j(rt.j jVar, Context context) {
        this.f53235b = jVar;
        this.f53236c = context;
    }

    public final void onClick(View view) {
        SpotOrderEmptyViewHandler.f(this.f53235b, this.f53236c, view);
    }
}
