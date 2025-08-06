package bg;

import android.content.Context;
import android.view.View;
import com.hbg.module.swap.viewhandler.SwapPositionViewHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12363b;

    public /* synthetic */ a(Context context) {
        this.f12363b = context;
    }

    public final void onClick(View view) {
        SwapPositionViewHandler.q(this.f12363b, view);
    }
}
