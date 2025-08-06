package mf;

import android.view.KeyEvent;
import android.widget.TextView;
import com.hbg.module.market.widget.ui.MarketWidgetSearchActivity;

public final /* synthetic */ class g implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketWidgetSearchActivity f58225b;

    public /* synthetic */ g(MarketWidgetSearchActivity marketWidgetSearchActivity) {
        this.f58225b = marketWidgetSearchActivity;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f58225b.wh(textView, i11, keyEvent);
    }
}
