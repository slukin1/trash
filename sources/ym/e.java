package ym;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f61819b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FutureContractInfo f61820c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f61821d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f61822e;

    public /* synthetic */ e(k kVar, FutureContractInfo futureContractInfo, String str, int i11) {
        this.f61819b = kVar;
        this.f61820c = futureContractInfo;
        this.f61821d = str;
        this.f61822e = i11;
    }

    public final void call(Object obj) {
        this.f61819b.K(this.f61820c, this.f61821d, this.f61822e, (List) obj);
    }
}
