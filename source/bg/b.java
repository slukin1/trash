package bg;

import android.view.View;
import com.hbg.module.swap.bean.SwapPositionItem;
import com.hbg.module.swap.viewhandler.SwapPositionViewHandler;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapPositionItem f12364b;

    public /* synthetic */ b(SwapPositionItem swapPositionItem) {
        this.f12364b = swapPositionItem;
    }

    public final void onClick(View view) {
        SwapPositionViewHandler.o(this.f12364b, view);
    }
}
