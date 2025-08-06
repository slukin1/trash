package vh;

import android.view.View;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.huobi.asset.widget.FilterBar;

public final /* synthetic */ class h0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonSwitchButton f61035b;

    public /* synthetic */ h0(CommonSwitchButton commonSwitchButton) {
        this.f61035b = commonSwitchButton;
    }

    public final void onClick(View view) {
        FilterBar.i(this.f61035b, view);
    }
}
