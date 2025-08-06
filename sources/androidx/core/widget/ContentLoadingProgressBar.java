package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: b  reason: collision with root package name */
    public long f8688b = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8689c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8690d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8691e = false;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f8692f = new e(this);

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f8693g = new f(this);

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f8689c = false;
        this.f8688b = -1;
        setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f8690d = false;
        if (!this.f8691e) {
            this.f8688b = System.currentTimeMillis();
            setVisibility(0);
        }
    }

    public final void e() {
        removeCallbacks(this.f8692f);
        removeCallbacks(this.f8693g);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }
}
