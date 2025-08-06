package gk;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import rx.functions.Func1;

public final /* synthetic */ class j implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f54838b;

    public /* synthetic */ j(String str) {
        this.f54838b = str;
    }

    public final Object call(Object obj) {
        return Boolean.valueOf(((FutureContractInfo) obj).getContractCode().equalsIgnoreCase(this.f54838b));
    }
}
