package vb;

import android.content.Context;
import com.hbg.lite.wallet.viewhandler.BalanceInfoFirstViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f61005b;

    public /* synthetic */ a(Context context) {
        this.f61005b = context;
    }

    public final void call(Object obj) {
        BalanceInfoFirstViewHandler.e(this.f61005b, (Void) obj);
    }
}
