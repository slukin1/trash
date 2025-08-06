package hb;

import android.widget.TextView;
import com.hbg.lite.market.widget.RectTabLayout;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RectTabLayout f54920b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f54921c;

    public /* synthetic */ g(RectTabLayout rectTabLayout, TextView textView) {
        this.f54920b = rectTabLayout;
        this.f54921c = textView;
    }

    public final void run() {
        this.f54920b.e(this.f54921c);
    }
}
