package qi;

import android.view.View;
import com.huobi.c2c.lend.view.C2CLendTradeLayout;

public final /* synthetic */ class m implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2CLendTradeLayout f53392b;

    public /* synthetic */ m(C2CLendTradeLayout c2CLendTradeLayout) {
        this.f53392b = c2CLendTradeLayout;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f53392b.z(view, z11);
    }
}
