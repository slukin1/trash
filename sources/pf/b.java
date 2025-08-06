package pf;

import android.view.KeyEvent;
import android.widget.TextView;
import com.hbg.module.market.widget.bean.MarketSearchInputItem;
import com.hbg.module.market.widget.viewhandler.MarketSearchInputHandler;

public final /* synthetic */ class b implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketSearchInputItem.a f53020b;

    public /* synthetic */ b(MarketSearchInputItem.a aVar) {
        this.f53020b = aVar;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return MarketSearchInputHandler.d(this.f53020b, textView, i11, keyEvent);
    }
}
