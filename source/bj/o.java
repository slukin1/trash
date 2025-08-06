package bj;

import com.huobi.contract.helper.ContractDataSource;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import rx.functions.Func1;

public final /* synthetic */ class o implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f12468b;

    public /* synthetic */ o(String[] strArr) {
        this.f12468b = strArr;
    }

    public final Object call(Object obj) {
        return ContractDataSource.i(this.f12468b, (LoginInfoData) obj);
    }
}
