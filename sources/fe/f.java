package fe;

import android.view.View;
import android.widget.TextView;
import com.hbg.module.kline.view.KLineIndexSelectorView;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KLineIndexSelectorView f54487b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f54488c;

    public /* synthetic */ f(KLineIndexSelectorView kLineIndexSelectorView, TextView textView) {
        this.f54487b = kLineIndexSelectorView;
        this.f54488c = textView;
    }

    public final void onClick(View view) {
        this.f54487b.f(this.f54488c, view);
    }
}
