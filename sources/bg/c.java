package bg;

import android.view.View;
import com.hbg.module.swap.bean.SwapPositionItem;
import com.hbg.module.swap.viewhandler.SwapPositionViewHandler;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapPositionItem f12365b;

    public /* synthetic */ c(SwapPositionItem swapPositionItem) {
        this.f12365b = swapPositionItem;
    }

    public final void onClick(View view) {
        SwapPositionViewHandler.u(this.f12365b, view);
    }
}
