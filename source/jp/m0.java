package jp;

import com.huobi.otc.helper.OtcLoginHelper;
import rx.functions.Func1;

public final /* synthetic */ class m0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f56037b;

    public /* synthetic */ m0(String[] strArr) {
        this.f56037b = strArr;
    }

    public final Object call(Object obj) {
        return OtcLoginHelper.j(this.f56037b, (String) obj);
    }
}
