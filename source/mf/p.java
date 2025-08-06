package mf;

import androidx.core.widget.NestedScrollView;
import com.hbg.lib.widgets.MyNestedScrollView;
import com.hbg.module.market.widget.ui.MarketWidgetSettingActivity;

public final /* synthetic */ class p implements MyNestedScrollView.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MarketWidgetSettingActivity f58234a;

    public /* synthetic */ p(MarketWidgetSettingActivity marketWidgetSettingActivity) {
        this.f58234a = marketWidgetSettingActivity;
    }

    public final void onScrollChange(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        this.f58234a.uh(nestedScrollView, i11, i12, i13, i14);
    }
}
