package dj;

import com.huobi.contract.entity.ContractCancelResult;
import rx.functions.Func1;

public final /* synthetic */ class u implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f53759b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f53760c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f53761d;

    public /* synthetic */ u(v vVar, String str, String str2) {
        this.f53759b = vVar;
        this.f53760c = str;
        this.f53761d = str2;
    }

    public final Object call(Object obj) {
        return this.f53759b.q(this.f53760c, this.f53761d, (ContractCancelResult) obj);
    }
}
