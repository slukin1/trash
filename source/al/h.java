package al;

import android.app.Activity;
import android.view.View;
import com.hbg.lib.data.symbol.TradeType;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f3569b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f3570c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TradeType f3571d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f3572e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f3573f;

    public /* synthetic */ h(boolean z11, Activity activity, TradeType tradeType, String str, String str2) {
        this.f3569b = z11;
        this.f3570c = activity;
        this.f3571d = tradeType;
        this.f3572e = str;
        this.f3573f = str2;
    }

    public final void onClick(View view) {
        i.r(this.f3569b, this.f3570c, this.f3571d, this.f3572e, this.f3573f, view);
    }
}
