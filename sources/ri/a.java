package ri;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.C2CLoanOrderBean;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.huobi.c2c.lend.bean.C2CLendOrderHistoryItem;
import com.huobi.c2c.lend.viewhandler.C2CLendOrderHistoryItemHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2CLendOrderHistoryItem f25657b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2CLoanOrderBean f25658c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommonSwitchButton f25659d;

    public /* synthetic */ a(C2CLendOrderHistoryItem c2CLendOrderHistoryItem, C2CLoanOrderBean c2CLoanOrderBean, CommonSwitchButton commonSwitchButton) {
        this.f25657b = c2CLendOrderHistoryItem;
        this.f25658c = c2CLoanOrderBean;
        this.f25659d = commonSwitchButton;
    }

    public final void onClick(View view) {
        C2CLendOrderHistoryItemHandler.d(this.f25657b, this.f25658c, this.f25659d, view);
    }
}
