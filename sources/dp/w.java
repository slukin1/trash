package dp;

import com.huobi.otc.dialog.OtcSmallCoinDialog;
import rx.functions.Action1;

public final /* synthetic */ class w implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcSmallCoinDialog f53886b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f53887c;

    public /* synthetic */ w(OtcSmallCoinDialog otcSmallCoinDialog, String str) {
        this.f53886b = otcSmallCoinDialog;
        this.f53887c = str;
    }

    public final void call(Object obj) {
        this.f53886b.xh(this.f53887c, (Long) obj);
    }
}
