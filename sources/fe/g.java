package fe;

import android.view.View;
import android.widget.TextView;
import com.hbg.module.kline.view.KLineIndexSelectorView;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KLineIndexSelectorView f54489b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f54490c;

    public /* synthetic */ g(KLineIndexSelectorView kLineIndexSelectorView, TextView textView) {
        this.f54489b = kLineIndexSelectorView;
        this.f54490c = textView;
    }

    public final void onClick(View view) {
        this.f54489b.e(this.f54490c, view);
    }
}
