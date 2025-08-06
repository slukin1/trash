package ze;

import android.content.Context;
import android.view.View;
import com.hbg.module.linear.swap.viewhandler.LinearSwapCurrentTimeOrderItemHandler;
import ye.b;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f62144b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f62145c;

    public /* synthetic */ g(b bVar, Context context) {
        this.f62144b = bVar;
        this.f62145c = context;
    }

    public final void onClick(View view) {
        LinearSwapCurrentTimeOrderItemHandler.f(this.f62144b, this.f62145c, view);
    }
}
