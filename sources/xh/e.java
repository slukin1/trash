package xh;

import android.widget.LinearLayout;
import com.huobi.asset2.index.component.AssetAccountListItemView;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearLayout f61604b;

    public /* synthetic */ e(LinearLayout linearLayout) {
        this.f61604b = linearLayout;
    }

    public final void call(Object obj) {
        this.f61604b.addView((AssetAccountListItemView) obj);
    }
}
