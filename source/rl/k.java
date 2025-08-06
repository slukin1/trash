package rl;

import android.view.View;
import android.widget.PopupWindow;
import com.huobi.view.HeavyBubblePopup;
import com.huobi.view.HighLightPopup;

public final /* synthetic */ class k implements PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HighLightPopup f25753b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HeavyBubblePopup f25754c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f25755d;

    public /* synthetic */ k(HighLightPopup highLightPopup, HeavyBubblePopup heavyBubblePopup, View view) {
        this.f25753b = highLightPopup;
        this.f25754c = heavyBubblePopup;
        this.f25755d = view;
    }

    public final void onDismiss() {
        l.e(this.f25753b, this.f25754c, this.f25755d);
    }
}
