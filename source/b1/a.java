package b1;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

public final class a extends ClickableSpan {

    /* renamed from: b  reason: collision with root package name */
    public final int f12284b;

    /* renamed from: c  reason: collision with root package name */
    public final AccessibilityNodeInfoCompat f12285c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12286d;

    public a(int i11, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i12) {
        this.f12284b = i11;
        this.f12285c = accessibilityNodeInfoCompat;
        this.f12286d = i12;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f12284b);
        this.f12285c.d0(this.f12286d, bundle);
    }
}
