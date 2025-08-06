package ym;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import rx.functions.Func1;

public final /* synthetic */ class h implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f61830b;

    public /* synthetic */ h(String str) {
        this.f61830b = str;
    }

    public final Object call(Object obj) {
        return Boolean.valueOf(((FutureContractInfo) obj).getContractCode().equalsIgnoreCase(this.f61830b));
    }
}
