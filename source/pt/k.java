package pt;

import android.content.Context;
import android.view.View;
import com.huobi.tradenew.handler.SpotOrderEmptyViewHandler;
import rt.j;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f53237b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f53238c;

    public /* synthetic */ k(j jVar, Context context) {
        this.f53237b = jVar;
        this.f53238c = context;
    }

    public final void onClick(View view) {
        SpotOrderEmptyViewHandler.e(this.f53237b, this.f53238c, view);
    }
}
