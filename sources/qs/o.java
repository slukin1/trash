package qs;

import com.hbg.lib.network.swap.core.bean.SwapCancelResult;
import com.hbg.lib.network.swap.core.bean.SwapCurrentOrderInfo;
import com.hbg.lib.network.swap.core.bean.SwapOrderResult;
import com.hbg.lib.network.swap.core.bean.SwapTriggerOrderInfo;
import l9.a;
import rx.Observable;

public final class o {
    public static Observable<SwapCancelResult> a(String str, String str2, int i11) {
        if (i11 == 1) {
            return a.a().t(str, str2).b();
        }
        return a.a().H(str, str2).b();
    }

    public static Observable<SwapOrderResult<SwapCurrentOrderInfo>> b(String str, String str2, int i11, int i12) {
        return a.a().G(i11, i12, str, str2).b();
    }

    public static Observable<SwapOrderResult<SwapTriggerOrderInfo>> c(String str, int i11, int i12) {
        return a.a().M(i11, i12, str).b();
    }
}
