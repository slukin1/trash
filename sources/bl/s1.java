package bl;

import android.content.Context;
import com.huobi.asset.widget.BottomLineTextView;
import com.huobi.finance.viewhandler.AssetSpotItemViewAdapter;
import rx.functions.Action1;

public final /* synthetic */ class s1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomLineTextView f12731b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f12732c;

    public /* synthetic */ s1(BottomLineTextView bottomLineTextView, Context context) {
        this.f12731b = bottomLineTextView;
        this.f12732c = context;
    }

    public final void call(Object obj) {
        AssetSpotItemViewAdapter.s(this.f12731b, this.f12732c, (Void) obj);
    }
}
