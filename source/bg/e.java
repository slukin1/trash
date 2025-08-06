package bg;

import android.view.View;
import com.hbg.module.swap.bean.SwapPositionItem;
import com.hbg.module.swap.viewhandler.SwapPositionViewHandler;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapPositionItem f12367b;

    public /* synthetic */ e(SwapPositionItem swapPositionItem) {
        this.f12367b = swapPositionItem;
    }

    public final void onClick(View view) {
        SwapPositionViewHandler.v(this.f12367b, view);
    }
}
