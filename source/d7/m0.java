package d7;

import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import rx.functions.Func1;

public final /* synthetic */ class m0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ m0 f53517b = new m0();

    public final Object call(Object obj) {
        return Boolean.valueOf(!((CurrencyBean) obj).hasTag("hidden"));
    }
}
