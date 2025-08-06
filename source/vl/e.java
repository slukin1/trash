package vl;

import android.view.MotionEvent;
import android.view.View;
import com.huobi.homemarket.view.MarketOptionSettingDialogFragment;

public final /* synthetic */ class e implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketOptionSettingDialogFragment f61071b;

    public /* synthetic */ e(MarketOptionSettingDialogFragment marketOptionSettingDialogFragment) {
        this.f61071b = marketOptionSettingDialogFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f61071b.lambda$addEvent$0(view, motionEvent);
    }
}
