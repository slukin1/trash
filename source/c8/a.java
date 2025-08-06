package c8;

import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexCurrencyInfoController f13011b;

    public /* synthetic */ a(IndexCurrencyInfoController indexCurrencyInfoController) {
        this.f13011b = indexCurrencyInfoController;
    }

    public final Object call(Object obj) {
        return this.f13011b.n((IndexCurrencyInfo) obj);
    }
}
