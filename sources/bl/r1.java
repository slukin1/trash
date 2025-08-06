package bl;

import android.content.Context;
import com.huobi.asset.widget.BottomLineTextView;
import com.huobi.finance.viewhandler.AssetSpotItemViewAdapter;
import rx.functions.Action1;

public final /* synthetic */ class r1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomLineTextView f12722b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f12723c;

    public /* synthetic */ r1(BottomLineTextView bottomLineTextView, Context context) {
        this.f12722b = bottomLineTextView;
        this.f12723c = context;
    }

    public final void call(Object obj) {
        AssetSpotItemViewAdapter.r(this.f12722b, this.f12723c, (Void) obj);
    }
}
