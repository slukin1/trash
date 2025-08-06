package bg;

import android.view.View;
import com.hbg.module.swap.bean.SwapPositionItem;
import com.hbg.module.swap.viewhandler.SwapPositionViewHandler;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapPositionItem f12366b;

    public /* synthetic */ d(SwapPositionItem swapPositionItem) {
        this.f12366b = swapPositionItem;
    }

    public final void onClick(View view) {
        SwapPositionViewHandler.t(this.f12366b, view);
    }
}
