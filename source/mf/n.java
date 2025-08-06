package mf;

import android.view.MotionEvent;
import android.view.View;
import com.hbg.module.market.widget.ui.MarketWidgetSettingActivity;

public final /* synthetic */ class n implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketWidgetSettingActivity f58232b;

    public /* synthetic */ n(MarketWidgetSettingActivity marketWidgetSettingActivity) {
        this.f58232b = marketWidgetSettingActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f58232b.th(view, motionEvent);
    }
}
