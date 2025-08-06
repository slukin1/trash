package en;

import android.view.View;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.huobi.linearswap.viewhandler.PriceProtectionItemHandler;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonSwitchButton f54358b;

    public /* synthetic */ b(CommonSwitchButton commonSwitchButton) {
        this.f54358b = commonSwitchButton;
    }

    public final void onClick(View view) {
        PriceProtectionItemHandler.h(this.f54358b, view);
    }
}
