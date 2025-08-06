package cn;

import android.view.View;
import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;

public final /* synthetic */ class b2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapTradeBaseFragment f13120b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f13121c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f13122d;

    public /* synthetic */ b2(LinearSwapTradeBaseFragment linearSwapTradeBaseFragment, String str, String str2) {
        this.f13120b = linearSwapTradeBaseFragment;
        this.f13121c = str;
        this.f13122d = str2;
    }

    public final void onClick(View view) {
        this.f13120b.yj(this.f13121c, this.f13122d, view);
    }
}
