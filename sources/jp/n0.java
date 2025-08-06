package jp;

import com.huobi.otc.helper.OtcLoginHelper;
import rx.functions.Func1;

public final /* synthetic */ class n0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f56040b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56041c;

    public /* synthetic */ n0(String[] strArr, String str) {
        this.f56040b = strArr;
        this.f56041c = str;
    }

    public final Object call(Object obj) {
        return OtcLoginHelper.i(this.f56040b, this.f56041c, (String) obj);
    }
}
