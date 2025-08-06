package u8;

import com.hbg.lib.network.otc.core.bean.TradingStatus;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ a f60548b = new a();

    public final Object call(Object obj) {
        return Integer.valueOf(((TradingStatus) obj).getStatus());
    }
}
