package com.blankj.utilcode.util;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Objects;

public abstract class ClickUtils$OnDebouncingClickListener implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    public static boolean f63301d = true;

    /* renamed from: e  reason: collision with root package name */
    public static final Runnable f63302e = new a();

    /* renamed from: b  reason: collision with root package name */
    public long f63303b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63304c;

    public static class a implements Runnable {
        public void run() {
            boolean unused = ClickUtils$OnDebouncingClickListener.f63301d = true;
        }
    }

    public ClickUtils$OnDebouncingClickListener() {
        this(true, 1000);
    }

    public static boolean b(View view, long j11) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return a0.D(view, j11);
    }

    public abstract void c(View view);

    @SensorsDataInstrumented
    public final void onClick(View view) {
        if (this.f63304c) {
            if (f63301d) {
                f63301d = false;
                view.postDelayed(f63302e, this.f63303b);
                c(view);
            }
        } else if (b(view, this.f63303b)) {
            c(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public ClickUtils$OnDebouncingClickListener(boolean z11, long j11) {
        this.f63304c = z11;
        this.f63303b = j11;
    }
}
