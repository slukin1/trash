package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.browser.R$dimen;

@Deprecated
public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public final int f4848b = getResources().getDimensionPixelOffset(R$dimen.browser_actions_context_menu_min_padding);

    /* renamed from: c  reason: collision with root package name */
    public final int f4849c = getResources().getDimensionPixelOffset(R$dimen.browser_actions_context_menu_max_width);

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f4848b * 2), this.f4849c), 1073741824), i12);
    }
}
