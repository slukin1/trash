package es;

import android.view.View;
import bs.b;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.huobi.staring.viewhandler.RemindSettingListItemHandler;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f54419b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommonSwitchButton f54420c;

    public /* synthetic */ k(b bVar, CommonSwitchButton commonSwitchButton) {
        this.f54419b = bVar;
        this.f54420c = commonSwitchButton;
    }

    public final void onClick(View view) {
        RemindSettingListItemHandler.d(this.f54419b, this.f54420c, view);
    }
}
