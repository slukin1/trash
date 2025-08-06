package ql;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.homemarket.handler.CollEditViewHandler;
import com.huobi.homemarket.model.CollEditModel;
import v9.c;

public final /* synthetic */ class k implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollEditModel f60037b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f60038c;

    public /* synthetic */ k(CollEditModel collEditModel, c cVar) {
        this.f60037b = collEditModel;
        this.f60038c = cVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return CollEditViewHandler.g(this.f60037b, this.f60038c, view, motionEvent);
    }
}
